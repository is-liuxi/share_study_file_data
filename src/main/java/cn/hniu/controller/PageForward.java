package cn.hniu.controller;

import cn.hniu.pojo.*;
import cn.hniu.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 用于跳转页面
 */
@Controller
public class PageForward {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;

    @Autowired
    GroupinfoService groupinfoService;

    @Autowired
    HighNumberService highNumberService;

    @Autowired
    EnglishService englishService;

    @Autowired
    ComputerService computerService;

    @Autowired
    PoliticsService politicsService;

    @GetMapping("/index")
    public String loginPage() {

        return "index";
    }

    @GetMapping("mainPage")
    public String mainPage() {

        return "main";
    }

    @GetMapping("manage/addAdminPage")
    public String addAdminPage() {

        return "manage/addAdmin";
    }

    @GetMapping("manage/adminPage")
    public String adminPage(Model model) {
        List<User> userList = userService.queryAllUser();
        model.addAttribute("userList", userList);
        return "manage/admin";
    }

    @GetMapping("registerPage")
    public String registerPage() {

        return "register";
    }

    @GetMapping("updateUserPage/{userId}")
    public String updateUserPage(@PathVariable("userId") Integer userId, Model model) {
        User user = userService.queryUserById(userId);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @GetMapping("shareFile")
    public String shareFile(Model model) {
        List<Groupinfo> groupinfoList = groupinfoService.queryAllGroupDetaild();
        model.addAttribute("groupinfoList", groupinfoList);
        return "shareFile";
    }

    @PostMapping("shareFileUpload")
    public String shareFileUpload(MultipartFile file, @RequestParam("groupId") Integer groupId,
                                  @RequestParam("title") String title, @RequestParam("content") String content,
                                  HttpServletRequest req) throws IOException {
        logger.info("文件上传请求的数据：所属分组：" + groupId + "  标题：" + title + "  内容：" + content + " 文件：" + file);

        // 文件上传后存放的路径
        String filePath = "";

        // 上传文件名 + 后缀
        String fileName = file.getOriginalFilename();

        // 文件名
        String n = fileName.substring(0, fileName.indexOf("."));

        String pre = fileName.substring(fileName.indexOf("."));
        logger.info("上传文件后缀：" + pre);

        // logger.info("上传文件名：" + fileName);
        String uuid = UUID.randomUUID().toString();
        String name = uuid.replaceAll("-", "").substring(8);
        logger.info("UUID生成的文件名：" + name);

        // 保存的 UUID文件名
        String currentFileName = "/static/upload/" + name + pre;
        logger.info("UUID生成后的文件名 + 文件后缀：" + currentFileName);

        // 将文件保存到项目 /static/upload 中
        // 无效
        String uploadPath = req.getSession().getServletContext().getRealPath("/");

        // 目录为源码目录下 upload
        // String uploadPath = "D:/Project/money/work/share_study_file_data/src/main/webapp";
        logger.info("上传文件后的目录" + uploadPath);

        filePath = uploadPath + currentFileName;
        logger.info("上传后文件路径和文件名：：" + filePath);

        File f = new File(filePath);
        if (!f.exists()) {
            f.mkdir();
        }
        file.transferTo(f);

        // 上传一份到服务器中
        // String serverPathUpload = "D:\\jar\\apache-tomcat-8.5.30\\webapps\\data\\static\\upload";
        // file.transferTo(new File(serverPathUpload, currentFileName));

        // 高数模块处理
        if (0 < groupId && groupId <= 3) {
            highNumberService.addHighNumber(new HighNumber(title, content, currentFileName, groupId, n));
        }

        // 英语模块处理
        if (groupId == 4 || groupId == 5) {
            englishService.addEnglish(new English(title, content, currentFileName, groupId, n));
        }

        if (groupId == 6) {
            politicsService.addPolitics(new Politics(title, content, currentFileName, n));
        }

        if (groupId == 7) {
            computerService.addComputer(new Computer(title, content, currentFileName, n));
        }
        return "redirect:mainPage";
    }

    // 找回密码
    @GetMapping("resetPWDPage")
    public String resetPWDPage(){

        return "resetPWD";
    }

}

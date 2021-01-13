package org.elsys.victor.controllers;

import org.elsys.victor.services.IndexService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class IndexController {
    private final String DIR;
    private final IndexService service;

    public IndexController(@Value("${DIR}") String DIR, IndexService service) {
        this.service = service;
        this.DIR = DIR;
    }

    @RequestMapping("favicon.ico")
    @ResponseBody
    void returnNoFavicon() {
    }

    @GetMapping("/file/**")
    public ResponseEntity<Resource> getResource(HttpServletRequest request) throws FileNotFoundException {

        String path = request.getRequestURI().replaceFirst("/file", "");
        File file = new File(Paths.get(this.DIR, path).toString());
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(URI.create(path));
        responseHeaders.set("Content-disposition", "attachment; filename=" + file.getName());

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @GetMapping(value="/create/**")
    public String createFile(HttpServletRequest request, @RequestParam String name, @RequestParam String type) throws IOException {
        Path path = Paths.get(request.getRequestURI().replace("/create",""), name);
        if (type.equals("folder")) {
            Files.createDirectory(Paths.get(DIR, path.toString()));
        } else {
            new File(Paths.get(DIR, path.toString()).toString()).createNewFile();
        }
        return "redirect:" + path.getParent() + "/";
    }

    @GetMapping("/**")
    public String getIndex(HttpServletRequest request, Model model) {
        Path path = Paths.get(request.getRequestURI());
        File[] dir = service.listDir(this.DIR + path);

        if (dir == null ) {
            File file = new File(this.DIR + path);
            if (file.exists()) {
                return ("forward:/file/" + path);
            } else {
                return "redirect:/error";
            }
        }

        model.addAttribute("path", path + (path.endsWith("/") ? "" : "/"));
        model.addAttribute("files", dir);
        return "index";
    }



}

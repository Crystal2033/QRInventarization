/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.controller;

import org.crystal.qrserviceinventarization.service.ProjectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/projectors")
public class ProjectorController {
    private final ProjectorService projectorService;

    @Autowired
    public ProjectorController(ProjectorService projectorService) {
        this.projectorService = projectorService;
    }
}

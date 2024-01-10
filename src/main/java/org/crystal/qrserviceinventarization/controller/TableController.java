/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.controller;

import org.crystal.qrserviceinventarization.database.model.SystemUnit;
import org.crystal.qrserviceinventarization.database.model.Table;
import org.crystal.qrserviceinventarization.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/tables")
public class TableController {
    private final TableService tableService;

    @Autowired
    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping("/{cabinetId}")
    public ResponseEntity<List<Table>> getTablesByCabinetId(@PathVariable Long cabinetId){
        return new ResponseEntity<>(tableService.getTablesByCabinetId(cabinetId), HttpStatus.OK);
    }
}

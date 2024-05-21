package kea.bowlingBackend.project.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import kea.bowlingBackend.project.dto.EquipmentDTO;
import kea.bowlingBackend.project.model.Equipment;
import kea.bowlingBackend.project.service.EquipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/{id}")
    public EquipmentDTO getEquipment(@PathVariable int id) {
        return equipmentService.getEquipmentById(id);
    }

    @GetMapping
    public List<EquipmentDTO> getAllEquipment() {
        return equipmentService.getAllEquipment();
    }

    @PostMapping
    public EquipmentDTO addEquipment(@RequestBody EquipmentDTO equipment) {
        return equipmentService.addEquipment(equipment);
    }

    @PutMapping("/{id}")
    public EquipmentDTO updateEquipment(@PathVariable int id, @RequestBody EquipmentDTO updatedEquipment) {
        EquipmentDTO original = equipmentService.getEquipmentById(id);
        return equipmentService.updateEquipment(original, updatedEquipment);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipment(@PathVariable int id) {
        equipmentService.deleteEquipment(id);
    }

}

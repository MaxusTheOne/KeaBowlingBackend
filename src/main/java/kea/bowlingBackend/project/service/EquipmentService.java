package kea.bowlingBackend.project.service;

import kea.bowlingBackend.project.dto.EquipmentDTO;
import kea.bowlingBackend.project.model.Equipment;
import kea.bowlingBackend.project.repository.EquipmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;
    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public EquipmentDTO toDTO(Equipment equipment) {
        return new EquipmentDTO(equipment.getId(), equipment.getName(), equipment.getDescription(), equipment.getBrand(), equipment.getType(), equipment.getStockAmount());
    }

    public EquipmentDTO getEquipmentById(int id) {
        Equipment equipment = equipmentRepository.findById((long) id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipment not found"));
        return toDTO(equipment);
    }

    public List<EquipmentDTO> getAllEquipment() {
        List<Equipment> equipment = equipmentRepository.findAll();
        return equipment.stream().map(this::toDTO).toList();
    }

    public EquipmentDTO addEquipment(EquipmentDTO request) {
        if (request.id() != 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot provide an ID for creating a new equipment");
        }
        Equipment newEquipment = new Equipment();
        updateEquipment(newEquipment, request);
        equipmentRepository.save(newEquipment);
        return toDTO(newEquipment);
    }

    public EquipmentDTO updateEquipment(Equipment original, EquipmentDTO request) {
        original.setName(request.name());
        original.setDescription(request.description());
        original.setBrand(request.brand());
        original.setType(request.type());
        return toDTO(original);
    }

    public EquipmentDTO updateEquipment(EquipmentDTO original, EquipmentDTO request) {
        Equipment equipment = equipmentRepository.findById((long) original.id()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipment not found"));
        updateEquipment(equipment, request);
        equipmentRepository.save(equipment);
        return toDTO(equipment);
    }

    public void deleteEquipment(int id) {
        Equipment equipment = equipmentRepository.findById((long) id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipment not found"));
        equipmentRepository.delete(equipment);
    }

}

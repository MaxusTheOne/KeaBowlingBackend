package kea.bowlingBackend.project.configuration;

import kea.bowlingBackend.project.model.Equipment;
import kea.bowlingBackend.project.repository.EquipmentRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SetupTestEquipment implements ApplicationRunner {

    EquipmentRepository equipmentRepository;

    public SetupTestEquipment(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public void run(ApplicationArguments args) {
        createTestEquipment();
    }

    private void createTestEquipment() {
        //Create test equipment
        Equipment equipment1 = new Equipment("GreaseBall 9000", "A heavy ball used for bowling", "Brunswick", "Ball", 12);
        Equipment equipment2 = new Equipment("Smooth Steppas", "Shoes used for bowling", "Brunswick", "Shoes", 12);
        Equipment equipment3 = new Equipment("MungoBallSack", "A bag used for carrying bowling equipment", "Storm", "Bag", 12);
        Equipment equipment4 = new Equipment("Grip n' Flip", "Gloves used for bowling", "Ebonite", "Gloves", 12);
        Equipment equipment5 = new Equipment("Sweat Wiper Ultimate", "A towel used for cleaning bowling equipment", "900 Global", "Towel", 12);

        equipmentRepository.save(equipment1);
        equipmentRepository.save(equipment2);
        equipmentRepository.save(equipment3);
        equipmentRepository.save(equipment4);
        equipmentRepository.save(equipment5);



    }
}

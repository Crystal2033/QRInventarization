/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 11.01.2024
 */

package org.crystal.qrserviceinventarization.config;

import org.crystal.qrserviceinventarization.database.misc.Converter;
import org.crystal.qrserviceinventarization.database.model.*;
import org.crystal.qrserviceinventarization.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseStarter implements CommandLineRunner {
    private final OrganizationRepository organizationRepository;
    private final BranchRepository branchRepository;
    private final BuildingRepository buildingRepository;

    private final CabinetRepository cabinetRepository;

    private final ChairRepository chairRepository;

    private final CityRepository cityRepository;

    public DatabaseStarter(OrganizationRepository organizationRepository,
                           BranchRepository branchRepository,
                           BuildingRepository buildingRepository,
                           CabinetRepository cabinetRepository,
                           ChairRepository chairRepository, CityRepository cityRepository) {
        this.organizationRepository = organizationRepository;
        this.branchRepository = branchRepository;
        this.buildingRepository = buildingRepository;
        this.cabinetRepository = cabinetRepository;
        this.chairRepository = chairRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        City city = City.builder()
                .name("Moscow")
                .build();
        city = cityRepository.save(city);

        Organization organization = Organization
                .builder()
                .id(0L)
                .name("MAI")
                .build();
        organization = organizationRepository.save(organization);

        Branch branch = Branch.builder()
                .id(0L)
                .name("MoscowMAI")
                .city(city)
                .organization(organization)
                .build();

        branch = branchRepository.save(branch);

        Building building = Building.builder()
                .address("Volokolamskoye shosse, 4k1")
                .branch(branch)
                .build();
        building = buildingRepository.save(building);

        Cabinet cabinet = Cabinet.builder()
                .id(0L)
                .name("IT-17")
                .building(building)
                .build();
        cabinet = cabinetRepository.save(cabinet);


        byte[] image = Converter.fromImageToBytes("C:\\Users\\kulik\\OneDrive\\Изображения\\Saved Pictures\\magicForest.jpg");
        Chair chair = Chair.builder()
                .id(0L)
                .name("Blue chair")
                .inventoryNumber("ABCD1234")
                .image(image)
                .cabinet(cabinet)
                .build();

        chair = chairRepository.save(chair);


    }
}

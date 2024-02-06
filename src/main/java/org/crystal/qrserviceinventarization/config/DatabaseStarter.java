/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 11.01.2024
 */

package org.crystal.qrserviceinventarization.config;

import org.crystal.qrserviceinventarization.database.model.*;
import org.crystal.qrserviceinventarization.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@Configuration
public class DatabaseStarter implements CommandLineRunner {
    private final OrganizationRepository organizationRepository;
    private final BranchRepository branchRepository;
    private final BuildingRepository buildingRepository;

    private final CabinetRepository cabinetRepository;

    private final ChairRepository chairRepository;

    private final MonitorRepository monitorRepository;

    private final CityRepository cityRepository;

    private final UserRepository userRepository;

    public DatabaseStarter(OrganizationRepository organizationRepository,
                           BranchRepository branchRepository,
                           BuildingRepository buildingRepository,
                           CabinetRepository cabinetRepository,
                           ChairRepository chairRepository, MonitorRepository monitorRepository, CityRepository cityRepository, UserRepository userRepository) {
        this.organizationRepository = organizationRepository;
        this.branchRepository = branchRepository;
        this.buildingRepository = buildingRepository;
        this.cabinetRepository = cabinetRepository;
        this.chairRepository = chairRepository;
        this.monitorRepository = monitorRepository;
        this.cityRepository = cityRepository;
        this.userRepository = userRepository;
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        return outputImage;
    }

    public byte[] toByteArray(BufferedImage bi, String format)
            throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, format, baos);
        return baos.toByteArray();
    }

    private byte[] getResizedImageInBytes(String path, int targetWidth, int targetHeight) throws IOException {
        String[] splittedPathByDot = path.split("\\.");
        BufferedImage buffImage = ImageIO.read(new File(path));
        buffImage = resizeImage(buffImage, targetWidth, targetHeight);
        return toByteArray(buffImage, splittedPathByDot[splittedPathByDot.length - 1]);
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

        Cabinet cabinet1 = Cabinet.builder()
                .id(0L)
                .name("IT-17")
                .building(building)
                .build();

        cabinet1 = cabinetRepository.save(cabinet1);

        Cabinet cabinet2 = Cabinet.builder()
                .id(0L)
                .name("IT-15")
                .building(building)
                .build();
        cabinet2 = cabinetRepository.save(cabinet2);

        byte[] image1 = getResizedImageInBytes("C:\\Users\\kulik\\OneDrive\\Изображения\\Saved Pictures\\cat1.jpg", 200, 200);

//        Chair chair = Chair.builder()
//                .id(0L)
//                .name("Blue chair")
//                .inventoryNumber("ABCD1234")
//                .image(image1)
//                .cabinet(cabinet1)
//                .build();
//
//        chair = chairRepository.save(chair);
//
//        byte[] image2 = getResizedImageInBytes("C:\\Users\\kulik\\OneDrive\\Изображения\\Saved Pictures\\cat2.jpg", 200, 200);
//
//        Monitor monitor = Monitor.builder()
//                .id(0L)
//                .name("Black monitor")
//                .inventoryNumber("5490SDKW")
//                .image(image2)
//                .cabinet(cabinet1)
//                .build();
//
//        monitor = monitorRepository.save(monitor);

        User user = User.builder()
                .login("1")
                .password("2")
                .firstName("Paul")
                .secondName("Kulikov")
                .organization(organization)
                .id(0L)
                .build();

        userRepository.save(user);


    }
}

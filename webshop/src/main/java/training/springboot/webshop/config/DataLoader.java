package training.springboot.webshop.config;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import training.springboot.webshop.entity.Product;
import training.springboot.webshop.persistence.ProductRepository;

@Component
@Profile("dev")
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    ProductRepository productRepository;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        long existingProductCount = productRepository.count();
        if (existingProductCount > 0) {
            return;
        }

        productRepository.saveAll(generateProducts());
        
    }

    private List<Product> generateProducts() {
        Product[] products = new Product[]{
            new Product("Smartphone X", new BigDecimal("499.99"), "A powerful smartphone with a high-resolution display and advanced camera features."),
            new Product("Laptop Pro 15 inch", new BigDecimal("1099.99"), "An ultra-thin laptop with a fast processor and long-lasting battery life."),
            new Product("Wireless Headphones", new BigDecimal("149.95"), "Immerse yourself in music with these comfortable and high-quality wireless headphones."),
            new Product("4K Smart TV", new BigDecimal("799.99"), "Experience stunning visuals and smart features on this 4K Ultra HD television."),
            new Product("Fitness Tracker", new BigDecimal("69.99"), "Stay active and monitor your health with this sleek fitness tracker."),
            new Product("Digital Camera", new BigDecimal("399.99"), "Capture memories in stunning detail with this versatile digital camera."),
            new Product("Coffee Maker", new BigDecimal("59.95"), "Brew your favorite coffee at home with this easy-to-use coffee maker."),
            new Product("Bluetooth Speaker", new BigDecimal("79.99"), "Enjoy your music on the go with this portable and powerful Bluetooth speaker."),
            new Product("Gaming Console", new BigDecimal("299.99"), "Enter the world of gaming with this next-gen gaming console."),
            new Product("Electric Toothbrush", new BigDecimal("49.99"), "Keep your teeth clean and healthy with this electric toothbrush."),
            new Product("Stainless Steel Cookware Set", new BigDecimal("199.99"), "Elevate your cooking with this durable and stylish cookware set."),
            new Product("Tablet PC", new BigDecimal("329.99"), "A versatile tablet for work and entertainment on the move."),
            new Product("Wireless Mouse", new BigDecimal("29.99"), "Stay productive with this comfortable and wireless computer mouse."),
            new Product("Home Security Camera", new BigDecimal("129.95"), "Keep an eye on your home with this easy-to-install security camera."),
            new Product("Noise-Canceling Earbuds", new BigDecimal("129.99"), "Block out distractions and enjoy crystal-clear audio with these earbuds."),
            new Product("Smart Thermostat", new BigDecimal("149.95"), "Control your home's temperature from anywhere with this smart thermostat."),
            new Product("Portable Charger", new BigDecimal("39.99"), "Stay connected on the go with this high-capacity portable charger."),
            new Product("Robot Vacuum Cleaner", new BigDecimal("249.99"), "Let this robot vacuum take care of your cleaning chores automatically."),
            new Product("Outdoor Grill", new BigDecimal("299.95"), "Host the perfect BBQ with this durable and feature-packed outdoor grill."),
            new Product("Electric Scooter", new BigDecimal("349.99"), "Zip around town with ease on this eco-friendly electric scooter."),
            new Product("Smartwatch", new BigDecimal("199.99"), "Stay connected and track your fitness goals with this stylish smartwatch."),
            new Product("Digital Air Fryer", new BigDecimal("89.95"), "Cook healthier meals with less oil using this digital air fryer."),
            new Product("Wireless Keyboard", new BigDecimal("49.99"), "Type comfortably and wirelessly with this sleek keyboard."),
            new Product("Home Theater System", new BigDecimal("599.99"), "Transform your living room into a cinematic experience with this home theater system."),
            new Product("E-book Reader", new BigDecimal("129.99"), "Read your favorite books on the go with this lightweight e-book reader."),
            new Product("Cordless Vacuum Cleaner", new BigDecimal("179.95"), "Clean your home effortlessly with this cordless vacuum cleaner."),
            new Product("In-Ear Monitors", new BigDecimal("79.99"), "Enjoy professional-grade audio quality with these in-ear monitors."),
            new Product("Smart Doorbell", new BigDecimal("199.95"), "Enhance your home security with a video-enabled smart doorbell."),
            new Product("Electric Bike", new BigDecimal("999.99"), "Commute with ease and style on this electric bike."),
            new Product("Wireless Charging Pad", new BigDecimal("19.99"), "Charge your devices wirelessly with this convenient charging pad."),
            new Product("Smart Scale", new BigDecimal("59.95"), "Track your fitness progress and monitor your health with this smart scale."),
            new Product("Robot Lawn Mower", new BigDecimal("349.99"), "Keep your lawn manicured without lifting a finger using this robot lawn mower."),
            new Product("Car Dash Camera", new BigDecimal("89.99"), "Capture every moment on the road with this car dash camera."),
            new Product("Yoga Mat", new BigDecimal("29.95"), "Practice yoga comfortably with this non-slip yoga mat."),
            new Product("Wireless Earphones", new BigDecimal("59.99"), "Enjoy tangle-free music on the go with these wireless earphones."),
            new Product("LED Desk Lamp", new BigDecimal("39.99"), "Illuminate your workspace with adjustable brightness and color temperature."),
            new Product("Smart Plug", new BigDecimal("19.95"), "Make any device smart with this Wi-Fi-enabled smart plug."),
            new Product("Pressure Cooker", new BigDecimal("79.99"), "Cook meals faster and more efficiently with this pressure cooker."),
            new Product("Electric Fireplace", new BigDecimal("299.95"), "Create a cozy atmosphere with this electric fireplace."),
            new Product("Waterproof Bluetooth Speaker", new BigDecimal("49.99"), "Take your music anywhere, even near water, with this waterproof Bluetooth speaker."),
            new Product("Car Phone Mount", new BigDecimal("19.99"), "Securely mount your phone in your car with this adjustable phone mount."),
            new Product("Gaming Mouse", new BigDecimal("49.95"), "Gain a competitive edge with this high-precision gaming mouse."),
            new Product("Desk Organizer", new BigDecimal("29.99"), "Keep your workspace neat and organized with this desk organizer."),
            new Product("Cordless Drill", new BigDecimal("79.99"), "Tackle DIY projects with ease using this cordless drill."),
            new Product("Gaming Headset", new BigDecimal("69.99"), "Immerse yourself in gaming audio with this comfortable gaming headset."),
            new Product("Air Purifier", new BigDecimal("149.95"), "Breathe cleaner air in your home with this HEPA air purifier.")
        };
        return Arrays.stream(products).toList();
    }
    
}

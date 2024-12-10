public class Exercise03 {
    public static void main(String[] args) {
        OperatingSystem windows = new OperatingSystem("Windows", "11", "Microsoft", 64);
        OperatingSystem macos = new OperatingSystem("macOS", "Ventura", "Apple", 64);
        OperatingSystem linux = new OperatingSystem("Ubuntu", "22.04", "Canonical", 64);
    }
}

class OperatingSystem {
    private String name;
    private String version;
    private String manufacturer;
    private int bitArchitecture; // 32 или 64 бита

    public OperatingSystem(String name, String version, String manufacturer, int bitArchitecture) {
        this.name = name;
        this.version = version;
        this.manufacturer = manufacturer;
        this.bitArchitecture = bitArchitecture;

        System.out.println("Создан экземпляр операционной системы:");
        System.out.println("Название: " + name);
        System.out.println("Версия: " + version);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Разрядность: " + bitArchitecture + "-bit\n");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getBitArchitecture() {
        return bitArchitecture;
    }

    public void setBitArchitecture(int bitArchitecture) {
        this.bitArchitecture = bitArchitecture;
    }
}

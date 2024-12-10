public class exercise02 {
    public static void main(String[] args) {

        OperatingSystem windows = new OperatingSystem();

        windows.name = "Windows";
        windows.developer = "Microsoft company";
        windows.kernelType = "Hybrid Kernel";
        windows.latestVersion = "Windows 11. 24H2";
        windows.platform = "ARM64, x86, x86-x64";

        OperatingSystem macOS = new OperatingSystem();

        macOS.name = "macOS";
        macOS.developer = "Apple Inc";
        macOS.kernelType = "Hybrid Kernel XNU";
        macOS.latestVersion = "macOS 15 Sequoia";
        macOS.platform = "Apple Silicon, Intel x86-x64";

        OperatingSystem Linux = new OperatingSystem();

        Linux.name = "Linux";
        Linux.developer = "Linux Foundation";
        Linux.kernelType = "Linux";
        Linux.latestVersion = "Linux 6.7";
        Linux.platform = "ARM, ARM64, x86, x64, PowerPC, MIPS, RISC-V";

        OperatingSystem Android = new OperatingSystem();

        Android.name = "Android";
        Android.developer = "Google, Open Handset Alliance";
        Android.kernelType = "Linux";
        Android.latestVersion = "Android 15 (Vanilla Ice Cream)";
        Android.platform = "Android, ARM, x86-64";

        OperatingSystem iOS = new OperatingSystem();

        iOS.name = "iOS";
        iOS.developer = "Apple Inc";
        iOS.kernelType = "Hybrid Kernel XNU";
        iOS.latestVersion = "iOS 18";
        iOS.platform = "iPhone, iPad и iPod Touch";

    }
}

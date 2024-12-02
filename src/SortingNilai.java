import java.util.*;

public class SortingNilai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Opsi pilihan
        System.out.println("======================================");
        System.out.println("=========== Selamat Datang ===========");
        System.out.println("======= Program Sorting Nilai ========");
        System.out.println("======================================");

        System.out.println("\nSilakan pilih opsi sorting:");
        System.out.println("1. Sorting berdasar nilai");
        System.out.println("2. Sorting berdasar nama");
        System.out.println("3. Sorting berdasarkan nilai & nama");
        System.out.print("Pilihan Anda (1/2/3): ");
        
        int p = scanner.nextInt();
        
        // Input jumlah mahasiswa
        System.out.println("\n======================================");
        System.out.print("Masukkan jumlah mahasiswa: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Mengonsumsi newline

        // Array untuk menyimpan nama dan nilai mahasiswa
        String[] names = new String[n];
        int[] grades = new int[n];

        // Input data mahasiswa
        for (int i = 0; i < n; i++) {
            System.out.print("Nama mahasiswa ke-" + (i + 1) + " : ");
            names[i] = scanner.nextLine();
            System.out.print("Nilai mahasiswa ke-" + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
            scanner.nextLine(); // Mengonsumsi newline
        }
        System.out.println("======================================");

        // Pilihan sorting berdasarkan input pengguna
        switch (p) {
            case 1:
                insertionSort(names, grades);
                System.out.println("\nData setelah sorting berdasarkan nilai:");
                break;
            case 2:
                bubbleSortByName(names, grades);
                System.out.println("\nData setelah sorting berdasarkan nama:");
                break;
            case 3:
                insertionSort(names, grades);
                bubbleSortByNameWithinSameGrade(names, grades);
                System.out.println("\nData setelah sorting berdasarkan nilai & nama:");
                break;
            default:
                System.out.println("\nPilihan tidak valid.");
                scanner.close();
                return;
        }

        // Menampilkan data hasil sorting
        printStudentData(names, grades);

        // Menutup scanner
        scanner.close();
    }

    // Insertion Sort untuk mengurutkan nilai dan nama
    public static void insertionSort(String[] names, int[] grades) {
        int n = grades.length;
        for (int i = 1; i < n; i++) {
            int keyGrade = grades[i];
            String keyName = names[i];
            int j = i - 1;

            // Pindahkan elemen grades[j] yang lebih besar dari keyGrade ke satu posisi ke depan
            while (j >= 0 && grades[j] > keyGrade) {
                grades[j + 1] = grades[j];
                names[j + 1] = names[j];
                j--;
            }

            // Letakkan keyGrade dan keyName di posisi yang sesuai
            grades[j + 1] = keyGrade;
            names[j + 1] = keyName;
        }
    }

    // Bubble Sort untuk mengurutkan nama
    public static void bubbleSortByName(String[] names, int[] grades) {
        int n = names.length;
        boolean swapped;

        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (names[i].compareToIgnoreCase(names[i + 1]) > 0) {
                    // Tukar nama
                    String tempName = names[i];
                    names[i] = names[i + 1];
                    names[i + 1] = tempName;

                    // Tukar nilai agar sinkron
                    int tempGrade = grades[i];
                    grades[i] = grades[i + 1];
                    grades[i + 1] = tempGrade;

                    swapped = true;
                }
            }
        } while (swapped);
    }

    // Bubble Sort untuk mengurutkan nama dalam kelompok nilai yang sama
    public static void bubbleSortByNameWithinSameGrade(String[] names, int[] grades) {
        int n = names.length;
        boolean swapped;
        
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (grades[i] == grades[i + 1] && names[i].compareToIgnoreCase(names[i + 1]) > 0) {
                    // Tukar nama
                    String tempName = names[i];
                    names[i] = names[i + 1];
                    names[i + 1] = tempName;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    // Fungsi untuk mencetak data mahasiswa
    public static void printStudentData(String[] names, int[] grades) {
        System.out.printf("%-20s %-10s%n", "Nama", "Nilai");
        System.out.println("-------------------- ----------");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%-20s %-10d%n", names[i], grades[i]);
        }
    }
}
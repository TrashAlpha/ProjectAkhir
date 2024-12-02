import java.util.*;

public class SortingNilai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("======================================");
        System.out.println("=========== Selamat Datang ===========");
        System.out.println("======= Program Sorting Nilai ========");

        // Loop utama program
        while (true) {
            // Opsi pilihan
            System.out.println("======================================");
            System.out.println("\nSilakan pilih opsi sorting:");
            System.out.println("1. Sorting berdasar nilai");
            System.out.println("2. Sorting berdasar nama");
            System.out.println("3. Sorting berdasarkan nilai & nama");
            System.out.println("4. Keluar");
            System.out.print("Pilihan Anda (1/2/3/4): ");
            
            int p = scanner.nextInt();
            scanner.nextLine();

            if (p == 4) {
                System.out.println("\nTerima kasih telah menggunakan program ini. Sampai jumpa!");
                break; // Keluar dari loop
            }

            // Input jumlah mahasiswa
            System.out.println("\n======================================");
            System.out.print("Masukkan jumlah mahasiswa: ");
            int n = scanner.nextInt();
            scanner.nextLine();

            // Array untuk menyimpan nama dan nilai mahasiswa
            String[] names = new String[n];
            int[] grades = new int[n];

            // Input data mahasiswa
            for (int i = 0; i < n; i++) {
                System.out.print("Nama mahasiswa ke-" + (i + 1) + " : ");
                names[i] = scanner.nextLine();
                System.out.print("Nilai mahasiswa ke-" + (i + 1) + ": ");
                grades[i] = scanner.nextInt();
                scanner.nextLine();
            }
            System.out.println("======================================");

            // Pilihan sorting berdasarkan input pengguna
            switch (p) {
                case 1:
                    insertionSort(names, grades);
                    System.out.println("\nData setelah sorting berdasarkan nilai:");
                    break;
                case 2:
                    selectionSort(names, grades);
                    System.out.println("\nData setelah sorting berdasarkan nama:");
                    break;
                case 3:
                    insertionSort(names, grades);
                    bubbleSort(names, grades);
                    System.out.println("\nData setelah sorting berdasarkan nilai & nama:");
                    break;
                default:
                    System.out.println("\nPilihan tidak valid.");
                    continue;
            }

            // Menampilkan data hasil sorting
            printStudentData(names, grades);
            System.out.println();
        }

        scanner.close();
    }

    // Insertion Sort untuk mengurutkan nilai
    public static void insertionSort(String[] names, int[] grades) {
        int n = grades.length;
        for (int i = 1; i < n; i++) {
            int keyGrade = grades[i];
            String keyName = names[i];
            int j = i - 1;

            while (j >= 0 && grades[j] > keyGrade) {
                grades[j + 1] = grades[j];
                names[j + 1] = names[j];
                j--;
            }

            grades[j + 1] = keyGrade;
            names[j + 1] = keyName;
        }
    }

    // Selection Sort untuk mengurutkan nama
    public static void selectionSort(String[] names, int[] grades) {
        int n = names.length;
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (names[j].compareToIgnoreCase(names[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            String tempName = names[minIndex];
            names[minIndex] = names[i];
            names[i] = tempName;

            int tempGrade = grades[minIndex];
            grades[minIndex] = grades[i];
            grades[i] = tempGrade;
        }
    }

    // Bubble Sort untuk mengurutkan nama dalam kelompok nilai yang sama
    public static void bubbleSort(String[] names, int[] grades) {
        int n = names.length;
        boolean swapped;
        
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (grades[i] == grades[i + 1] && names[i].compareToIgnoreCase(names[i + 1]) > 0) {
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
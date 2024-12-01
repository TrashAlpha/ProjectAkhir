import java.util.*;

public class SortingNilai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input jumlah mahasiswa
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

        // Mengurutkan data berdasarkan nilai menggunakan Insertion Sort
        insertionSort(names, grades);
        System.out.println("\nData setelah sorting berdasarkan nilai:");
        printStudentData(names, grades);

        // Memilih apakah ingin mengurutkan berdasarkan nama
        System.out.print("\nApakah Anda ingin mengurutkan berdasarkan nama? (ya/tidak): ");
        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("ya")) {
            bubbleSort(names, grades);
            System.out.println("\nData setelah sorting berdasarkan nama:");
            printStudentData(names, grades);
        } else {
            System.out.println("\nData tidak diurutkan berdasarkan nama.");
        }

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

    // Bubble Sort untuk mengurutkan nama dalam kelompok nilai yang sama
    public static void bubbleSort(String[] names, int[] grades) {
        int n = names.length;
        boolean swapped;
        
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                // Hanya tukar jika nilai sama dan nama[i] lebih besar dari nama[i+1]
                if (grades[i] == grades[i + 1] && names[i].compareToIgnoreCase(names[i + 1]) > 0) {
                    // Tukar nama
                    String tempName = names[i];
                    names[i] = names[i + 1];
                    names[i + 1] = tempName;
                    
                    // Menandai bahwa ada pertukaran
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
# Manajemen Nilai Siswa

Proyek **Manajemen Nilai Siswa** adalah aplikasi berbasis *Graphical User Interface* (GUI) yang dibangun menggunakan bahasa pemrograman Java dengan pustaka *Swing*. Aplikasi ini bertujuan untuk membantu pengelolaan data siswa dan nilai mereka, dengan fitur utama seperti menambah, mengedit, menghapus data siswa, serta memasukkan dan mengedit nilai siswa. Aplikasi ini juga memungkinkan pengguna untuk melihat data siswa secara lengkap dalam bentuk tabel.

## Fitur
- **Tambah Siswa**: Menambahkan data siswa baru termasuk nama, NIS, kelas, dan foto siswa.
- **Edit Siswa**: Mengubah data siswa yang sudah ada berdasarkan ID siswa.
- **Hapus Siswa**: Menghapus siswa dari daftar berdasarkan ID siswa.
- **Input Nilai**: Memasukkan nilai untuk siswa yang sudah ada dalam tiga mata pelajaran.
- **Edit Nilai**: Mengubah nilai yang telah dimasukkan untuk siswa.
- **Lihat Nilai**: Menampilkan data siswa lengkap dengan nilai-nilai yang telah dimasukkan dalam bentuk tabel.

## Persyaratan Sistem
Untuk menjalankan aplikasi ini, Anda memerlukan:
- **Java Development Kit (JDK) 8** atau versi yang lebih tinggi.
- **IDE**: Disarankan menggunakan IntelliJ IDEA, Eclipse, atau NetBeans.
- **Sistem Operasi**: Aplikasi ini dapat dijalankan di Windows, macOS, atau Linux yang memiliki Java terinstal.

## Penjelasan Struktur Kode
### 1. ManajemenGui.java :
- Kelas utama yang bertanggung jawab untuk menampilkan antarmuka pengguna (GUI).
   Menggunakan komponen GUI seperti JPanel, JButton, dan JTable untuk membangun tampilan aplikasi.
   Memiliki berbagai form untuk input data seperti penambahan, pengeditan, dan penghapusan data siswa serta input nilai.
### 2. Manajemen.java
   - Kelas yang bertugas untuk mengelola data siswa dan nilai mereka.
   Menyimpan data siswa dalam daftar (list) dan mengelola operasi seperti menambah, mengedit, menghapus siswa, serta memasukkan dan mengubah nilai siswa.
### 3. Siswa.java
  - Kelas yang menyimpan data individual siswa, seperti ID, nama, NIS, kelas, foto, dan nilai-nilai mereka.
   Menyediakan metode getter dan setter untuk mengakses dan mengubah data siswa.
### 4. Main.java
  - Titik masuk utama untuk menjalankan aplikasi.
   Memulai kelas ManajemenGui yang akan menampilkan antarmuka pengguna.
   Penggunaan
   Setelah aplikasi berjalan, Anda dapat menggunakan fitur-fitur berikut:

### 1. Tambah Siswa
 -  Pilih menu Tambah Siswa di sidebar.
   Masukkan informasi siswa, termasuk nama, NIS, kelas, dan foto siswa.
   Klik tombol Tambah Siswa untuk menyimpan data siswa.
### 2. Edit Siswa
  - Pilih menu Edit Siswa di sidebar.
   Pilih siswa yang akan diedit dari dropdown list berdasarkan ID siswa.
   Masukkan data baru untuk siswa tersebut dan klik Edit Siswa untuk menyimpan perubahan.
### 3. Hapus Siswa
 -  Pilih menu Hapus Siswa di sidebar.
   Pilih siswa yang akan dihapus dari daftar berdasarkan ID siswa.
   Klik Hapus Siswa untuk menghapus data siswa tersebut.
### 4. Input Nilai
 -  Pilih menu Input Nilai di sidebar.
   Pilih siswa yang nilai-nilainya akan diinputkan.
   Masukkan nilai untuk tiga mata pelajaran dan klik Input Nilai untuk menyimpan nilai.
### 5. Edit Nilai
 -  Pilih menu Edit Nilai di sidebar.
   Pilih siswa yang nilai-nilainya akan diedit.
   Masukkan nilai baru untuk mata pelajaran yang ingin diubah dan klik Edit Nilai untuk menyimpan perubahan.
### 6. Lihat Nilai
 -  Pilih menu Lihat Nilai di sidebar.
   Tabel akan menampilkan daftar semua siswa beserta nilai mereka dalam tiga mata pelajaran. Anda bisa menggulir tabel untuk melihat data secara lebih lengkap.
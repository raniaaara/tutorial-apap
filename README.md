# :sunflower: :cherry_blossom: Tutorial APAP :cherry_blossom: :sunflower:

### Authors

**Rania Azzahra** - **1806185475** - **APAP-B**


## Tutorial 1 
### What I have learned today :computer:

> Github

**1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?**

Issue Tracker adalah sebuah alat pelacak isu/masalah, dalam hal ini kita dapat mencatat masalah-masalah apa saja yang sedang dialami oleh sebuah tim. Issue tracker juga dapat berfungsi untuk merencanakan sebuah pekerjaan yang nantinya akan diselesaikan. Dengan begitu, masalah dan perubahan permintaan yang ada dapat dilacak atau diketahui.

Masalah-masalah yang dapat di-track antara lain:
- Membahas implementasi ide baru
- Melacak tugas dan status pekerjaan
- Menerima proposal fitur baru, pertanyaan, permintaan dukungan, dan laporan bug
- Mengelaborasi implementasi kode yang baru


**2. Apa perbedaan dari git merge dan git merge --squash?**

Squash merge adalah sebuah pilihan merge yang disediakan oleh git yang hanya akan menghasilkan sebuah merge commit dengan satu parent, di saat normal merge akan menghasilkan dua parent. File tetap akan digabungkan seperti halnya saat melakukan normal merge, bedanya terletak pada commit metadata yang diubah untuk menunjukkan bahwa hanya ada satu parent commit. Hasilnya adalah commit tunggal pada branch target dengan semua perubahan dari normal merge. Sederhananya, squash merge menghasilkan history yang lebih bersih dari pada normal merge.


**3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?**

Version Control seperti git memiliki cukup banyak keunggulan dalam pengembangan suatu aplikasi. Salah satunya adalah pengembangan aplikasi dapat dilakukan secara paralel tanpa harus menunggu salah satu fitur diselesaikan. Dengan menggunakan fitur branch dan merge yang tersedia, tim pengembang dapat mengembangkan aplikasi secara paralel tanpa takut mengalami conflict antara versi satu sama lain.


> Spring

**4. Apa itu library & dependency?**

Library adalah sekumpulan potongan kode terkait yang telah di-compile dan disimpan bersama dalam satu file. File itu dapat ditautkan dengan kode kita untuk memberi kita akses ke kode di library tersebut.

Dependency adalah ketika suatu aplikasi tidak hanya terdiri dari satu objek. Bahkan aplikasi yang paling sederhana memiliki beberapa objek yang bekerja bersama untuk menyajikan apa yang dilihat end-user sebagai aplikasi yang koheren.


**5. Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?**

Maven adalah alat manajemen proyek yang menangani pembangunan proyek, dependensi, distribusi, perilisan, dan lain-lain menggunakan Java. Di sini, pembuatan perangkat lunak mengacu pada proses dimana source code dikonversi menjadi bentuk yang berdiri sendiri dan dapat dijalankan oleh komputer. Maven menggunakan file XML untuk menggambarkan proyek yang dibangun.

Kita perlu menggunakan Maven karena hal berikut:
- Maven dapat mengelola 'a complete project life-cycle', misalnya: Code compilation > Unit testing > Build generation (jar and war files)
- Mudah mengelola dependensi eksternal untuk proyek berbasis Java dan menjaga proyek Java tetap ringan
- Manajemen proyek multi-level, yaitu berbagi fungsionalitas satu proyek dengan beberapa proyek lainnya menggunakan manajemen dependensi

Selain Maven, kita dapat menggunakan alternatif lain seperti Gradle. Gradle adalah sistem otomasi build yang sepenuhnya open source dan menggunakan konsep yang kita lihat di Apache Maven dan Apache Ant. Ini menggunakan bahasa domain-specific berdasarkan bahasa pemrograman Groovy, membedakannya dari Apache Maven, yang menggunakan XML untuk konfigurasi proyeknya. Ini juga menentukan urutan tugas yang dijalankan dengan menggunakan grafik asiklik terarah. Singkatnya, perbedaan utama antara Maven dan Gradle adalah bahwa Maven adalah alat manajemen proyek dan pemahaman perangkat lunak yang mengelola pembuatan, laporan, dan dokumen proyek, sementara Gradle adalah alat otomatisasi open source build yang berfokus pada fleksibilitas dan kinerja.


**6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?**

Spring digunakan juga untuk mengembangkan aplikasi berskala enterprise, akses data, messaging, testing, manajemen transaksi, juga aplikasi pada ranah keamanan dan big data. Selain itu, Spring juga dapat dikembangkan untuk aplikasi web berbasis MVC dan webservice framework RESTful.


**7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan@RequestParam atau @PathVariable?**

@PathVariable berfungsi untuk mengekstrak nilai dari URI. Sedangkan @RequestParam berfungsi untuk mendaparkan parameter dari URI, yang biasa dikenal sebagai parameter query. @RequestParam lebih berguna untuk aplikasi web yang bersifat tradisional dimana sebagaian besar data diteruskan dalam parameter query sementara, sedangkan @PathVariable lebih berguna untuk layanan web dengan framework RESTful dimana URL berisi nilai-nilai.


### What I did not understand :weary: :weary: :weary:
- [ ] Kenapa saya harus belajar APAP?
- [ ] Kenapa APAP susah dimengerti?


## Tutorial 2 
### What I have learned today :computer:

**1. Cobalah untuk menambahkan sebuah resep dengan mengakses link berikut http://localhost:8080/resep/add?noResep=1&namaDokter=Papa%20APAP&namaPasien=Quanta%20Fasilkom&catatan=Semangat, Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi**

Kita akan mendapatkan error yang disebabkan oleh ResepController yang mencoba untuk mengakses view "add-resep" yang belum dibuat. Hal ini dapat diselesaikan dengen membuat file add-resep.html pada folder template yang akan menerima atribut model dari Controller.


**2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat**

Anotasi @Autowired merupakan implementasi dari konsep Dependency Injection. Dengan @Autowired, kita tidak perlu setter dan constructor injection karena semua field/property yang memiliki anotasi @Autowired akan diisikan oleh Spring dengan object bertipe data sesuai.


**3. Cobalah untuk menambahkan sebuah resep dengan mengakses http://localhost:8080/resep/add?noResep=1&namaDokter=Papa%20APAP&namaPasien=Quanta%20Fasilkom. Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi**

Ketika saya mencoba mengakses link di atas, saya mendapatkan halaman bertuliskan Whitelabel Error beserta penjelasannya bahwa Whitelabel Error ini disebabkan karena kurangnya parameter "catatan" pada link tersebut. Pada ResepController, dapat dilihat bahwa atribut required pada parameter "catatan" bernilai True sehingga jika link yang kita coba akses tidak terdapat atribut "catatan", maka akan terjadi error.


**4. Jika Papa APAP ingin melihat resep untuk pasien yang bernama Quanta, link apa yang harus diakses?**

Jika berasumsi Papa APAP hanya mengetahui nama pasien, maka untuk melihat resepnya harus mengakses [http://localhost:8080/resep/viewall](http://localhost:8080/resep/viewall). Kemudian jika sudah tau nomor resepnya, maka Papa APAP dapat langsung mengakses [http://localhost:8080/resep/view?noResep=1](http://localhost:8080/resep/view?noResep=1).

*pasien bernama Quanta memiliki nomor resep 1


**5. Tambahkan 1 contoh resep lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/resep/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.**

Berikut link yang saya tambahkan: [http://localhost:8080/resep/add?noResep=2&namaDokter=BTS&namaPasien=Kim%20Seokjin&catatan=Borahae](http://localhost:8080/resep/add?noResep=2&namaDokter=BTS&namaPasien=Kim%20Seokjin&catatan=Borahae)

[Screenshot 1](https://ibb.co/YXrzxHw)

[Screenshot 2](https://ibb.co/D7SJQDj)





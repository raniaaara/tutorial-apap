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


### What I did not understand :weary: :weary: :weary:
- [ ] masih bingung gunanya service


## Tutorial 3
### What I have learned today :computer:

**1. Pada class ObatDb, terdapat method findByNoResep, apakah kegunaan dari method tersebut?**

Kegunaan dari method findByNoResep adalah untuk mencari data resep pada database berdasarkan NoResep yang telah diberikan. Method ini dibuat secara otomatis oleh Springboot karena saat Spring Data membuat @Repository baru, ia akan menganalisis semua method yang telah didefinisikan di interface kemudian mencoba untuk menghasilkan query pada method terkait.


**2. Pada class ResepController, jelaskan perbedaan method addResepFormPage dan addResepSubmit?**

Method addResepFormPage digunakan untuk mengembalikan halaman pendaftaran resep baru dan dipanggil saat browser melakukan request untuk mengakses /resep/add. Sedangkan method addResepSubmit dipanggil saat browser melakukan POST method untuk men-submit data resep tersebut. Pada HTML form-add-resep, method akan mengambil data yang telah dimasukkan, yang kemudian akan dimasukkan ke dalam database oleh method addResepSubmit.


**3. Jelaskan kegunaan dari JPA Repository!**

JPA (Java Persistence API) Repository digunakan untuk memasukkan objek-objek Java ke dalam relational database (SQL). Modul ini akan secara otomatis melakukan pemetaan dari Java class ke dalam bentuk tabel relasional. Terdapat dua bagian dalam JPA, yaitu sebuah mapping subsystem untuk melakukan mapping antara class-class ke relational table dan sebuah API EntityManager untuk mengakses objek-objek, mendefinisikan dan mengeksekusikan query, dan lainnya. Dengan menggunakan JPA Repository, akan lebih mudah bagi pengembang untuk mengelola objek-objek Java yang perlu kita masukkan ke dalam database beserta dengan ketentuan-ketentuannya.


**4. Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara ResepModel dan ObatModel dibuat?**

Pada ResepModel dan ObatModel terdapat @OneToMany dan @ManyToOne yang menunjukkan relasi model-model tersebut.  ResepModel menggunakan anotasi @OneToMany untuk mendefinisikan relasinya dengan tabel Obat diikuti dengan "List<ObjectModel> listObat" sebagai implementasinya dengan Java Objects. Sedangkan ObatModel menggunakan anotasi @ManyToOne untuk mendefinisikan relasinya dengan tabel Resep diikuti dengan "ResepModel resepmodel" sebagai referensinya dengan Java Objects. Dengan mendefinisikan relasi untuk kedua model ini, database akan lebih mudah dalam mengelola objek-objek yang ada.


**5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER!**

FetchType.LAZY memuat seluruh data Java objects yang di-fetch saat kita membutuhkan atau saat kita memanggil datanya (LAZY). Biasanya, FetchType ini digunakan untuk relasi one-to-many atau many-to-many. 

CascadeType.ALL digunakan agar segala (ALL) perubahan yang terjadi pada suatu entity akan terjadi juga pada entity seluruh child-nya. Perubahan dapat terjadi karena DELETE, UPDATE, dan sebagainya.

FetchType.EAGER memuat seluruh data Java objects yang di-fetch secara langsung, jadi ia melakukan fetch seawal mungkin. Biasanya, FetchType ini digunakan untuk relasi many-to-one atau one-to-one.

### What I did not understand :weary: :weary: :weary:
- [ ]


## Tutorial 4
### What I have learned today :computer:

**1. Jelaskan perbedaan th:include dan th:replace!**

th:include dan th:replace merupakan salah dua bentuk dari host tag, di mana ke dua host tag ini akan mengimplementasikan bentuk fragment yang disediakan oleh Thymeleaf. Fragment adalah sebuah reuseable class yang mengimplement beberapa fitur sebuah Activity.

Saat kita menggunakan include:

<div th:include="..."> contoh </div> --> konten akan ditempatkan di dalam <div> tag.

Saat kita menggunakan replace:

<div th:replace="..."> contoh </div> --> maka <div> akan digantikan dengan konten yang ada.

Thymeleaf dapat meng-include beberapa bagian dari halaman lain sebagai fragment menggunakan th:include (akan meng-include konten dari fragment ke host tag) atau th:replace (akan menggantikan host tag dengan fragment tersebut).


**2. Jelaskan apa fungsi dari th:object!**

th:object merupakan atribut yang menyimpan command object (bentuk dari bean object), yaitu bentuk representasi dari object yang berada pada backend. Dengan kata lain, th:object mereferensikan Model yang akan merepresentasikan state dari form yang dibuat. Contoh kita memiliki potongan kode seperti berikut:

<form th:action="@{/resep/add}" th:object="${resep}" method="POST">
Artinya, pada tag form tersebut kita menyisipkan th:object="${resep}" sebagai tanda bahwa form tersebut menggunakan objek resep sebagai model untuk pengumpulan data formnya.


**3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?**

Pada dasarnya, penggunaan * dan $ sama-sama digunakan untuk melakukan variable expression. Perbedannya terdapat jika * digunakan ketika melakukan expression pada selected object, bukan keseluruhan dari variable maps. Selama tidak ada object yang dipilih, maka * dan $ digunakan untuk hal yang sama.


**4. Bagaimana kamu menyelesaikan latihan nomor 3?**

Awalnya saya menambahkan atribut th:text pada elemen HTML dengan expression ${pageName}. Kemudian pada HTML yang mengimplementasikan fragment tersebut saya mengganti pageName dengan title halaman (home, add resep,dll) pada pemanggilan fragment navbar. 

Contoh:
<nav th:replace="fragments/fragment :: navbar('Delete Obat')"></nav>


### What I did not understand :weary: :weary: :weary:
- [ ]



## Tutorial 5
### What I have learned today :computer:

**1. Apa itu Postman? Apa kegunaannya?**

Postman merupakan development tool API yang digunakan untuk melakukan build, test, dan modify API. Dengan Postman, kita bisa mendesain, mock, debug, tes, mendokumentasikan, memonitor, dan menerbitkan API kita di satu tempat. Postman berfungsi sebagai REST Client dimana dapat digunakan untuk uji REST API. Ketika menggunakan Postman, untuk melakukan testing, kita tidak harus menulis HTTP client network code, tetapi membuat test suites yang dinamakan "Collections". Postman akan otomatis berinteraksi dengan API.


**2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.**

@JsonIgnoreProperties mengabaikan properti logis yang ditentukan dalam serialisasi dan deserialisasi JSON. Itu dijelaskan di tingkat kelas. Contohnya ketika kita memberikan true untuk elemen ignoreUnknown, maka dalam deserialization jika data JSON memiliki bidang yang tidak ada properti logis maka bidang JSON akan diabaikan dan tidak ada kesalahan akan dilemparkan. Sedangkan @JsonProperty merupakan anotasi yang berfungsi untuk mengubah nama variabel. @JsonProperty memberitahu Jackson ObjectMapper untuk memetakan nama property JSON ken ama bidang Java yang dianotasi.


**3. Apa kegunaan atribut WebClient?**

WebClient adalah sebuah interface yang disediakan oleh Spring Framework yang merupakan bagian dari reactive client dan berfungsi untuk poin akses utama dari web / HTTP requests. Modul ini berfungsi untuk menginstansiasi sebuah akses poin URL serta mengelola request dan response atas URL tersebut.


**4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?**

ResponseEntity mewakili respons HTTP, termasuk tajuk, isi, dan status. Sementara @ResponseBody menempatkan return value ke body dari response, ResponseEntity juga memungkinkan kita untuk menambahkan header dan kode status. Sedangkan BindingResult merupakan objek Spring yang menyimpan hasil dari validasi, binding, dan error atas model objek yang divalidasikan. BindingResult digunakan dengan diletakkan setelah parameter objek validasi.

### What I did not understand :weary: :weary: :weary:
- [ ]


## Tutorial 6
### What I have learned today :computer:

**1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?**

Otentikasi dilakukan untuk memverifikasi apakah seseorang itu adalah orang yang berhak. Biasanya melibatkan username dan password, tetapi dapat menyertakan metode lain yang dapat menunjukkan identitas seperti sidik jari. Sedangkan otorisasi merupakan pencarian apakah orang yang sudah diidentifikasi (diotentikasi), diperbolehkan untuk memanipulasi sumber daya tertentu. Pada tutorial ini konsep otentikasi diimplementasikan saat melakukan login pada url /login. Sedangkan, konsep otorisasi diimplementasikan ketika user telah berhasil masuk ke sistem dan sistem menampilkan fungsionalitas yang sesuai dengan kewenangan yang dimiliki oleh role masing-masing user (admin, apoteker, user)


**2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerjanya!**

BCryptPasswordEncoder merupakan algoritma hash password default untuk OpenBSD dan sistem lainnya, termasuk beberapa distribusi Linux seperti SUSE Linux. Awalan "$ 2a $" atau "$ 2b $" (atau "$ 2y $") dalam string hash dalam file kata kunci bayangan menunjukkan bahwa string hash adalah hash bcrypt dalam format kriptografi modular. Sisa dari string hash mencakup parameter biaya, salt 128 bit (basis-64 yang dikodekan sebagai 22 karakter), dan 184 bit dari nilai hash yang dihasilkan (basis-64 dikodekan sebagai 31 karakter). Cara kerjanya BCryptPasswordEncoder adalah saat kita membuat user baru dengan membuat username dan password baru, maka setelah kita klik 'save', maka password akan dienkripsi menggunakan fungsi BCrypt sehingga password yang terlihat pada database adalah password yang sudah dienkripsi.


**3. Jelaskan secara singkat apa itu UUID beserta penggunaannya!**

UUID (Universally Unique Identifier) merupakan kode identifikasi unik yang diberikan oleh sistem. UUID digunakan untuk memungkinkan sistem terdistribusi untuk secara unik mengidentifikasi informasi tanpa koordinasi pusat signifikan. Mirip seperti BCrypt, bedanya kali ini adalah ID, bukan password. Saat kita membuat user baru, sistem akan otomatis melakukan pemberian kode unik yang akan terlihat pada database dengan tipe UUID. Contoh penggunaan UUID pada tutorial ini adalah pada ID user, sehingga tidak ada user yang memiliki id yang sama. 


**4. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah memiliki class UserRoleServiceImpl.java?**

Class UserDetailsServiceImpl.java digunakan untuk memberikan informasi otentikasi dan otorisasi dari pengguna. Tujuannya adalah agar Spring Boot Security dapat melakukan proses otorisasi dan otentikasi pada akun pengguna sesuai dengan role yang telah diberikan saat pembuatan akun. Class ini harus ada karena class UserServiceImpl dan RoleServiceImpl tidak dapat memberikan informasi kepada Spring boot mengenai otentikasi dan otorisasi dari akun-akun yang ada pada database sistem.


### What I did not understand :weary: :weary: :weary:
- [ ]
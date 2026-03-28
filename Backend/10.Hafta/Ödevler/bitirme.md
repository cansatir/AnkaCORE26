# Spring Boot Web Servis Geliştirme - Bitirme Projesi

## Kütüphane Yönetim Sistemi (Library Management System)

### 1. Proje Amacı

Eğitim boyunca öğrendiğiniz tüm konuları (Java Temelleri, OOP, Koleksiyonlar, Exception Handling, Spring Boot, REST API, JPA, Validation, Exception Handling vb.) kullanarak, tam fonksiyonel bir RESTful web servisi geliştirmeniz beklenmektedir.

Bu proje, bir kütüphanenin temel işlemlerini yöneten bir backend sistemi olacaktır.

---

### 2. Proje Gereksinimleri

#### 2.1. Veritabanı Tasarımı

Aşağıdaki tabloları Entity modelleri kullanarak PostgreSQL üzerinde oluşturun:

**1. `authors` (Yazarlar)**
| Kolon | Tip | Açıklama |
|-------|-----|----------|
| id | Long | Otomatik artan |
| name | String(100) | NOT NULL |
| surname | String(100) | NOT NULL |
| birth_date | LocalDate | |
| nationality | String(50) | |
| created_at | LocalDateTime | |
| updated_at | LocalDateTime | |

**2. `categories` (Kategoriler)**
| Kolon | Tip | Açıklama |
|-------|-----|----------|
| id | Long | Otomatik artan |
| name | String(50) | NOT NULL, UNIQUE |
| description | String(255) | |

**3. `books` (Kitaplar)**
| Kolon | Tip | Açıklama |
|-------|-----|----------|
| id | Long (PK) | Otomatik artan |
| title | String(200) | NOT NULL |
| isbn | String(13) | NOT NULL, UNIQUE |
| publication_year | Integer | |
| total_copies | Integer | NOT NULL, varsayılan 1 |
| available_copies | Integer | NOT NULL |
| author_id | Long (FK) | authors(id) |
| category_id | Long (FK) | categories(id) |
| created_at | LocalDateTime | |
| updated_at | LocalDateTime | |

**4. `users` (Kullanıcılar)**
| Kolon | Tip | Açıklama |
|-------|-----|----------|
| id | Long (PK) | Otomatik artan |
| email | String(100) | NOT NULL, UNIQUE |
| first_name | String(50) | NOT NULL |
| last_name | String(50) | NOT NULL |
| phone | String(20) | |
| membership_date | LocalDate | NOT NULL |
| is_active | Boolean | Varsayılan true |

**5. `borrowings` (Ödünç Alma İşlemleri)**
| Kolon | Tip | Açıklama |
|-------|-----|----------|
| id | Long (PK) | Otomatik artan |
| user_id | Long (FK) | users(id) |
| book_id | Long (FK) | books(id) |
| borrow_date | LocalDate | NOT NULL |
| due_date | LocalDate | NOT NULL |
| return_date | LocalDate | |
| status | String(20) | BORROWED, RETURNED, OVERDUE |
| created_at | LocalDateTime | |

---

### 3. API Endpoint'leri

#### 3.1. Author Controller
| HTTP Metodu | Endpoint | Açıklama |
|-------------|----------|----------|
| POST | /api/authors | Yazar oluşturma |
| GET | /api/authors | Tüm yazarları listeleme |
| GET | /api/authors/{id} | ID'ye göre yazar getirme |
| PUT | /api/authors/{id} | Yazar güncelleme |
| DELETE | /api/authors/{id} | Yazar silme |
| GET | /api/authors/{id}/books | Yazara ait tüm kitapları listeleme |
| GET | /api/authors/search?name={name} | İsme göre yazar arama |

#### 3.2. Category Controller
| HTTP Metodu | Endpoint | Açıklama |
|-------------|----------|----------|
| POST | /api/categories | Kategori oluşturma |
| GET | /api/categories | Tüm kategorileri listeleme |
| GET | /api/categories/{id} | ID'ye göre kategori getirme |
| PUT | /api/categories/{id} | Kategori güncelleme |
| DELETE | /api/categories/{id} | Kategori silme |

#### 3.3. Book Controller
| HTTP Metodu | Endpoint | Açıklama |
|-------------|----------|----------|
| POST | /api/books | Kitap oluşturma |
| GET | /api/books | Tüm kitapları listeleme (sayfalama desteği) |
| GET | /api/books/{id} | ID'ye göre kitap getirme |
| PUT | /api/books/{id} | Kitap güncelleme |
| DELETE | /api/books/{id} | Kitap silme |
| GET | /api/books/isbn/{isbn} | ISBN'e göre kitap getirme |
| GET | /api/books/available | Mevcut kitapları listeleme |
| GET | /api/books/search?title={title} | Başlığa göre kitap arama |
| GET | /api/books/category/{categoryId} | Kategoriye göre kitapları listeleme |
| GET | /api/books/author/{authorId} | Yazara göre kitapları listeleme |

#### 3.4. User Controller
| HTTP Metodu | Endpoint | Açıklama |
|-------------|----------|----------|
| POST | /api/users | Kullanıcı oluşturma |
| GET | /api/users | Tüm kullanıcıları listeleme |
| GET | /api/users/{id} | ID'ye göre kullanıcı getirme |
| PUT | /api/users/{id} | Kullanıcı güncelleme |
| DELETE | /api/users/{id} | Kullanıcı silme |
| GET | /api/users/{id}/borrowings | Kullanıcının ödünç alma geçmişi |

#### 3.5. Borrowing Controller
| HTTP Metodu | Endpoint | Açıklama |
|-------------|----------|----------|
| POST | /api/borrowings | Kitap ödünç alma |
| PUT | /api/borrowings/{id}/return | Kitap iade etme |
| GET | /api/borrowings | Tüm ödünç işlemlerini listeleme |
| GET | /api/borrowings/{id} | ID'ye göre ödünç işlemi getirme |
| GET | /api/borrowings/overdue | Gecikmiş kitapları listeleme |
| GET | /api/borrowings/active | Aktif ödünç işlemlerini listeleme |

---

### 4. Proje Yapısı ve Teknik Gereksinimler

#### 4.1. Katmanlı Mimari
Projeniz aşağıdaki katmanlardan oluşmalıdır:

```
com.librarymanagementsystem/
├── controller/          # REST Controller sınıfları
├── service/             # İş mantığı katmanı
│   └── impl/            # Service implementasyonları
├── repository/          # Veri erişim katmanı (JPA Repository)
├── entity/              # JPA Entity sınıfları
├── dto/                 # Data Transfer Object sınıfları
│   ├── request/         # İstek DTO'ları
│   └── response/        # Yanıt DTO'ları
├── exception/           # Custom exception sınıfları
│   ├── handler/         # Global exception handler
│   └── CustomException.java
├── config/              # Konfigürasyon sınıfları
├── util/                # Yardımcı sınıflar
└── LibraryManagementSystemApplication.java
```

#### 4.2. Kullanılması Gereken Teknolojiler

| Teknoloji | Kullanım Amacı |
|-----------|---------------|
| Java 11+ | Temel programlama dili |
| Spring Boot 2.7+ | Framework |
| Spring Data JPA | Veritabanı işlemleri |
| PostgreSQL | Veritabanı |
| Maven/Gradle | Bağımlılık yönetimi |
| Lombok | Kod tekrarını azaltma |
| ModelMapper | Entity-DTO dönüşümü |
| Bean Validation | Input validasyonu |
| Swagger/OpenAPI | API dokümantasyonu |

#### 4.3. Zorunlu Teknik Gereksinimler

1. **DTO Kullanımı:**
   - Entity sınıfları doğrudan controller katmanında kullanılmamalıdır.
   - Her endpoint için uygun Request ve Response DTO'ları oluşturulmalıdır.

2. **Validasyon:**
   - Tüm input'lar @Valid ile doğrulanmalıdır.
   - Custom validasyon mesajları tanımlanmalıdır.

3. **Exception Handling:**
   - @ControllerAdvice ile global exception handling yapılmalıdır.
   - En az 3 adet custom exception sınıfı oluşturulmalıdır:
     - ResourceNotFoundException (kayıt bulunamadığında)
     - BusinessException (iş kuralları ihlallerinde)
     - DuplicateResourceException (aynı kayıt tekrar oluşturulmaya çalışıldığında)

4. **İş Kuralları:**
   - Bir kitap ödünç alınırken:
     - Kullanıcı aktif olmalı (is_active = true)
     - Kitabın available_copies > 0 olmalı
     - Aynı kullanıcı aynı kitabı daha önce iade etmemişse ve hala ödünç aldıysa tekrar ödünç alamaz
     - Bir kullanıcı en fazla 3 kitap ödünç alabilir
     - Ödünç alma süresi maksimum 30 gün olmalı (due_date)

   - Kitap iade edilirken:
     - İade tarihi kontrol edilmeli, gecikme varsa ceza hesaplanmalı (her gün için 5 TL)
     - Kitabın available_copies'i 1 artırılmalı
     - Borrowing durumu "RETURNED" olarak güncellenmeli

   - Yazar silinirken:
     - Yazara ait kitap varsa silme işlemi engellenmeli (BusinessException fırlatılmalı)

   - Kategori silinirken:
     - Kategoriye ait kitap varsa silme işlemi engellenmeli

   - Kitap silinirken:
     - Kitabın ödünç alınmış kopyaları varsa silme işlemi engellenmeli

5. **Sayfalama ve Sıralama:**
   - Tüm listeleme endpoint'leri sayfalama desteği sağlamalıdır.
   - Sayfa numarası, sayfa boyutu ve sıralama parametreleri alınabilmelidir.

6. **Loglama:**
   - Service katmanında kritik işlemler loglanmalıdır (info, error seviyelerinde).

7. **API Dokümantasyonu:**
   - Swagger/OpenAPI entegrasyonu yapılmalıdır.

---

### 5. Teslim Edilecekler

1. **Proje Kaynak Kodları:**
   - GitHub/GitLab reposu linki (public veya erişim izni verilmiş)
   - README.md dosyası içinde proje açıklaması ve kurulum adımları

2. **Veritabanı Yedekleme:**
   - PostgreSQL dump dosyası (.sql) - örnek verilerle birlikte

3. **API Test Dosyası:**
   - Postman Collection (.json) - tüm endpoint'leri kapsayan testler

4. **Proje Raporu (PDF):**
   - Kullanılan teknolojiler ve nedenleri
   - Veritabanı şeması (diagram)
   - API endpoint listesi
   - Karşılaşılan zorluklar ve çözümleri

---

### 6. Değerlendirme Kriterleri

| Kategori | Açıklama | Puan |
|----------|----------|------|
| **Java Temelleri** | OOP prensiplerine uygun kod yazımı, collection kullanımı, exception handling | 10 |
| **Proje Yapısı** | Katmanlı mimariye uygunluk, package organizasyonu | 10 |
| **Spring Boot Kullanımı** | Dependency Injection, IoC, configuration yönetimi | 10 |
| **REST API Tasarımı** | Endpoint isimlendirme kuralları, HTTP metodlarının doğru kullanımı | 10 |
| **Veritabanı İşlemleri** | JPA kullanımı, entity ilişkileri, repository yapısı | 10 |
| **DTO ve Validation** | DTO kullanımı, validasyon kuralları, custom validasyon mesajları | 10 |
| **Exception Handling** | Global exception handler, custom exception'lar, hata mesajları | 10 |
| **İş Kuralları** | Tüm iş kurallarının doğru implementasyonu | 15 |
| **Dokümantasyon** | Swagger entegrasyonu, README, Postman collection | 5 |
| **Kod Kalitesi** | Temiz kod prensipleri, naming conventions, gereksiz kod olmaması | 10 |
| **Toplam** | | **100** |

**Başarılı Olma Koşulu:** En az 70 puan almak.

---

### 7. Ekstra Bonus Puanlar

| Bonus | Açıklama | Puan |
|-------|----------|------|
| **JWT Authentication** | Spring Security ile JWT tabanlı kimlik doğrulama eklenmesi | +5 |
| **Unit Test** | Service katmanı için JUnit testleri yazılması (%80 coverage) | +5 |
| **Redis Cache** | Sık erişilen verilerin cache'lenmesi | +5 |
| **Docker** | Projenin Docker ile containerize edilmesi | +5 |
| **Raporlama Endpoint'i** | En çok ödünç alınan kitaplar, en aktif kullanıcılar gibi rapor endpoint'leri | +5 |

---

### 8. Zaman Planlaması

| Aşama | Süre | Tarih |
|-------|------|-------|
| Proje tanıtımı ve başlangıç | 1 gün | - |
| Veritabanı tasarımı ve entity oluşturma | 2 gün | - |
| Repository ve temel CRUD işlemleri | 2 gün | - |
| Service katmanı ve iş kuralları | 3 gün | - |
| Controller katmanı ve API endpoint'leri | 3 gün | - |
| Validation ve Exception Handling | 2 gün | - |
| Test, dokümantasyon ve teslimat | 2 gün | - |
| **Toplam** | **15 gün** | - |

---

### 9. Sık Sorulan Sorular

**S1: Projeyi bireysel mi yoksa grup olarak mı yapacağız?**
- Proje bireysel olarak yapılacaktır.

**S2: Veritabanı olarak farklı bir DB kullanabilir miyim?**
- PostgreSQL tercih edilmelidir, ancak H2 gibi in-memory bir veritabanı da kullanılabilir. Ancak teslim edilecek dump dosyası istenecektir.

**S3: Frontend geliştirmemiz gerekiyor mu?**
- Hayır, sadece backend REST API geliştirilecektir. API testleri Postman ile yapılacaktır.

**S4: Kullandığım IDE önemli mi?**
- Hayır, IntelliJ IDEA, Eclipse veya VS Code kullanabilirsiniz.

**S5: Yardım alabilir miyim?**
- Eğitmenlerinizden konu ile ilgili sorular sorabilirsiniz, ancak kod çözümü konusunda doğrudan yardım alınmayacaktır.

---

### 10. Teslimat Adresi ve Tarih

- **Teslim Tarihi:** [Tarih bilgisi eğitmen tarafından doldurulacak]
- **Teslim Adresi:** [GitHub repo linki ve proje raporu PDF olarak eğitmenin mail adresine gönderilecek]

---

**Başarılar!** 🚀

Bu proje, eğitim boyunca öğrendiğiniz tüm bilgileri pekiştirmeniz ve gerçek dünya senaryolarında nasıl kullanacağınızı göstermeniz için tasarlanmıştır. Spring Boot ile RESTful web servis geliştirme konusunda kendinizi geliştirmek için harika bir fırsat.

# 🦅 Siber Güvenlik Mühendisliği Eğitimi - 2026

> **"Bir mühendisin kalitesi, bulduğu açıkla değil; süreci nasıl yönettiği ve raporladığıyla ölçülür."**

Bu repo, AnkaCORE '26 eğitim programının **101 Aşaması Bitirme Projesi (Capstone Project)** teslim merkezidir. 5 haftalık zorlu temel eğitimin sonuna geldiniz. Bu proje, "Turistler" ile "Mühendisleri" birbirinden ayıracak olan final operasyonudur.

---

## 📅 101 BİTİRME PROJESİ: "The Analyst & The Hunter"

| Parametre | Detay |
| :--- | :--- |
| **Durum** | 🔴 FİNAL OPERASYONU (201'e Geçiş Bileti) |
| **Kapsam** | VDP Raporlama, Recon, Web Exploit, Ağ ve OS Analizi |
| **Zorluk Seviyesi** | ⭐⭐⭐⭐⭐ (5/5) |
| **Son Teslim** | 11 Mart Çarşamba 23:59 |

---

### 🚀 Görev Özeti

Siber güvenlikte 101 aşamasını bitirmek demek, temel araçları öğrenmek demek değildir; bir hedefe profesyonelce yaklaşmayı öğrenmek demektir. Önünüzde 10 günlük geniş bir süre var. Bu final projesi iki ana fazdan oluşmaktadır. Sizden beklenen, sahada gerçek bir "Bug Hunter" gibi iz sürmeniz ve ardından "Mühendis" kimliğinizle 3 farklı teknik cephede (Ağ, Web, OS) yeteneklerinizi kanıtlamanızdır.

---

### 📝 FAZ 1: "Siber Triatlon" Operasyon Raporu

Bu faz, aşağıdaki 2 ana bölümden (A ve B) oluşan, analizlerinizi **ekran görüntüleri ile kanıtladığınız**, teknik bir rapor formatında hazırlanmalıdır.

**⚠️ Rapor Kuralları:**
1.  **Kanıt Zorunluluğu:** Terminal komutları, Burp Suite istekleri/cevapları ve Wireshark filtreleri mutlaka ekran görüntüsü ile rapora eklenmelidir. Sadece "Şifre şudur" yazmak sıfır puandır.
2.  **Özgünlük:** İnternetteki CTF çözümlerini (Writeup) kopyalamayın. Kendi anladığınız şekilde, bir mühendise anlatır gibi "Neden bu komutu yazdım?" diyerek açıklayın.
3.  **Güvenlik (Kırmızı Çizgi):** Ağ analizi (Cephe 3) yaparken bulduğunuz zararlı IP ve domainlerle tarayıcınız üzerinden **kesinlikle** doğrudan etkileşime girmeyin!

---

#### **Bölüm A: Teori ve Mimari (Research & Logic)**

Laboratuvarlara saldırmadan önce, arkadaki mimariyi anlamalıyız. Aşağıdaki soruları teknik bir dille ve kendi cümlelerinizle yanıtlayın.

**1. İşletim Sistemi ve Şifreleme: "Anahtarlar Kimde?"**
* **SSH Private Key (Gizli Anahtar):** Parola (Password) ile giriş yapmak varken, sunuculara bağlanırken neden SSH Anahtarları (Public/Private Key) kullanırız? Bu sistemin güvenliğini sağlayan temel mantık nedir?
* **Hex Dump:** Bilgisayarlar için yazılmış binary (ikili) dosyaları okunabilir hale getiren "Hex Dump" nedir? (Level 12 için kritik).

**2. Web Mimarisi: "Sunucu Tarafı (Server-Side)"**
* **Client-Side vs Server-Side:** Bir web sayfasında "Sağ tık > Kaynağı İncele" dediğimizde HTML ve JavaScript kodlarını (Client-side) görebilirken, neden PHP veya Python (Server-side) kodlarını göremeyiz?
* **Command Injection (Komut Enjeksiyonu):** Bir web sitesindeki arama kutusuna yazılan masum bir metin, nasıl olur da arka plandaki Linux sunucusunda `ls` veya `whoami` komutlarının çalışmasına neden olur?

**3. Ağ Anatomisi: "Avın İzleri"**
* **C2 (Command and Control) Nedir?** Bir bilgisayara zararlı yazılım (Malware) bulaştığında, bu yazılım neden hacker'ın "C2 Sunucusuna" bağlanma ihtiyacı duyar? 

* **PCAP Analizi:** Bir SOC (Güvenlik Operasyon Merkezi) analisti, zararlı yazılımı tespit etmek için neden sadece antivirüs loglarına güvenmez de ağdaki PCAP (Packet Capture) dosyasını inceleme ihtiyacı duyar?

---

#### **Bölüm B: Saha Operasyonu (Boss Fights)**

Teori bitti, şimdi tetiği çekme zamanı. Konfor alanınızdan çıkın; aşağıdaki 3 cephenin **tamamında** operasyonu tamamlayıp çözüm adımlarınızı raporlayın.

#### 🛡️ Cephe 1: İşletim Sistemleri Ustası (Linux / Bash)
* **Hedef:** [OverTheWire: Bandit](https://overthewire.org/wargames/bandit/)
* **Görev:** **Level 11'den başlayıp Level 15'e kadar** (15 dahil) tamamlayın.
* **Beklenti & Raporlama:** * Level 13'te SSH Private Key (`.ssh/id_rsa`) kullanarak diğer kullanıcıya nasıl geçtiniz?
    * Level 14'te `nc` (Netcat) ile `localhost`'taki bir porta veriyi nasıl gönderdiniz?
    * Kullanılan komutları ve terminal ekran görüntülerini ekleyin.

#### 🌐 Cephe 2: Web Mantık Avcısı (Server-Side)
* **Hedef:** [OverTheWire: Natas](https://overthewire.org/wargames/natas/)
* **Görev:** **Level 0'dan Level 10'a kadar** (10 dahil) kesinlikle çözülmelidir.
* **Beklenti & Raporlama:**
    * Bu laboratuvar Burp Suite gerektirir!
    * Seviyeleri geçerken bulduğunuz zafiyetin türünü belirtin. (Örn: "Burada gizli dizin (Directory Listing) buldum", "Burada Local File Inclusion (LFI) ile `/etc/natas_webpass` dosyasını okudum").
    
    * Kaynak kod analizlerinizi ve Burp Suite / Tarayıcı ekran görüntülerini raporlayın.

#### 📡 Cephe 3: Kör Nokta Dedektifi (Ağ Adli Analizi)
* **Senaryo:** Satın alma departmanından Eric Fischer, bilinen bir kişiden gelen e-postadaki Word belgesini açıp yanlışlıkla "İçeriği Etkinleştir" butonuna tıkladı. SOC ekibi anında şüpheli dış bağlantı alarmları aldı ve ağ sensöründen alınan PCAP dosyasını size teslim etti.
* **Hedef:** [TryHackMe: C2 Carnage](https://tryhackme.com/room/c2carnage)
* **Görev:** Odaya girin, PCAP dosyasını Wireshark ile açın ve soruları yanıtlayarak zararlı yazılımın ağdaki izlerini sürün.
* **Beklenti & Raporlama:**
    * Zararlı bağlantıları, indirilen dosyaları ve komuta kontrol (C2) trafiğini tespit edin.
    * Soruları yanıtlarken **hangi Wireshark filtresini** (Örn: `http.request.method == "POST"`) kullandığınızı teknik olarak açıklayın ve Wireshark ekran görüntüsünü ekleyin.

---

### 🕵️‍♂️ FAZ 2: Gerçek Saha Operasyonu (Web Recon & VDP Raporu)
*Laboratuvar ortamını (Simülasyonu) geride bırakıyoruz. Artık kuralları şirketlerin koyduğu, gerçek hedeflerin olduğu vahşi doğadasınız.*

Bu fazda, HackerOne, Bugcrowd veya intigriti gibi global platformlar üzerinden gerçek bir VDP (Vulnerability Disclosure Program) hedefini seçecek ve öğrendiğiniz tüm "Recon" ve "Sömürü" yeteneklerini bu hedef üzerinde uygulayacaksınız. (Veya *.ankasec.co üzerinde de bu adımı deneyebilirsiniz. Sistemi çökertmemek kaydıyla :D)

---

#### **⚔️ BÖLÜM C: Av Mevsimi (Saha Adımları)**

Bir sisteme körü körüne saldırmadan önce haritasını çıkarmalı, ardından nokta atışı testler yapmalısınız. İşlemleri aşağıdaki cephe sırasına göre yürütün.

### 🗺️ Cephe 1: Hedef Seçimi ve Keşif (Recon Haritası)
Saldırganlar ana kapıdan değil, unutulmuş pencerelerden girer.
* **Hedef:** HackerOne veya Bugcrowd üzerinde "Public" (Herkese açık) ve "Safe Harbor" (Güvenli Liman / Test izni olan) bir şirket seçin. (Örn: Yahoo, Ford, Red Bull).
* **Operasyon:**
    1.  Terminalinizi açın ve `subfinder` veya `amass` kullanarak hedefin alt alan adlarını (subdomain) bulun.
    2.  Bulduğunuz listeyi `httpx` aracından geçirerek hangi sitelerin "200 OK" (Canlı) yanıtı verdiğini tespit edin.
    3.  Gözünüze kestirdiğiniz şüpheli bir subdomain üzerinde `dirsearch` ile gizli dizin taraması yapın.
* **Raporlama:** Hedefinizin adını belirtin. Recon aşamasında bulduğunuz en kritik 3 alt alan adını veya gizli dizini, terminal ekran görüntüleriyle (Kanıt) raporunuza ekleyin.

### 💉 Cephe 2: Zafiyet Avı (Vulnerability Assessment)
Recon aşamasında bulduğunuz sayfalara tarayıcınızdan gidin ve arka planda Burp Suite'i (Proxy) çalıştırın.
* **Operasyon:** Uygulamanın mantığını test edin.
    * *Girdi Alanları (Input):* Arama çubuklarında veya iletişim formlarında **XSS** veya **SQL Injection** tetiklemeye çalışın (`' OR 1=1 --` veya `<script>alert(1)</script>`).
    * *Erişim Kontrolü:* URL'deki parametrelerle oynayarak başkasının verisine ulaşmayı (**IDOR**) deneyin.
    * *Dosya Yükleme:* Profil fotoğrafı yükleme alanlarına zararsız bir `.txt` veya uzantısı değiştirilmiş dosya yükleyerek filtreleri test edin.

### 📋 Cephe 3: Profesyonel Raporlama (Kritik Teslimat)
Operasyon sonucunda iki senaryodan birini yaşayacaksınız. Raporunuzun bu bölümünü yaşadığınız senaryoya göre formatlayın:

* **🟢 Senaryo A (Açık Bulundu - Jackpot!):**
    Harika! Bulduğunuz açığı gerçek bir Bug Bounty platformuna bildiriyormuş gibi raporlayın.
    * **Vulnerability Title:** Açığın net adı (Örn: *Stored XSS on api.target.com/comments*).
    * **Steps to Reproduce (PoC):** Açığı tekrar üretmek için gereken adım adım liste ve Burp Suite ekran görüntüleri.
    * **Impact:** Bu açığın şirket için yarattığı gerçek risk.
    * **CVSS:** [CVSS Calculator](https://www.first.org/cvss/calculator/3.1) ile hesaplanmış skorunuz.

* **🟡 Senaryo B (Açık Bulunamadı - Gerçek Dünya):**
    Gerçek dünyada her gün açık bulamazsınız. Sistem güvenli olabilir veya WAF (Firewall) sizi engellemiş olabilir. Bu durumda bir **"Güvenlik Değerlendirme Raporu (Security Assessment)"** yazacaksınız.
    * **Test Edilen Endpointler:** Hangi URL'leri ve parametreleri test ettiniz?
    * **Kullanılan Payload'lar:** XSS veya SQLi için hangi zararlı kodları (Payload) denediniz? (Örn: `"test" parameters received <img src=x onerror=alert()> but encoded by server"`).
    * **Bulgular:** Sistemin savunma mekanizması nasıldı? (Örn: "Cloudflare WAF tespit edildi, XSS payloadlarım 403 Forbidden hatası aldı").
    * *Amaç:* Çabalarınızı ve mühendislik metodolojinizi bize kanıtlayın. "Denedim olmadı" demek yok; **nasıl** denediğinizi ekran görüntüleriyle anlatın.

---

#### **🧠 BÖLÜM D: Mühendislik Vizyonu (Reflection)**

*Saha operasyonunuz bitti. Şimdi klavyeyi bırakıp mimariyi düşünme zamanı.*

Aşağıdaki senaryo sorularına, bir siber güvenlik mühendisi (Consultant) vizyonuyla ve kendi cümlelerinizle cevap verin.

**1. Etki Analizi (Impact & CVSS Mantığı):**
*Senaryo:* Hedef şirkette iki farklı XSS zafiyeti buldunuz. 
Birincisi, şirketin ana sayfasında kimsenin uğramadığı bir "Hakkımızda" sayfasındaki arama çubuğunda (Reflected XSS). İkincisi ise yöneticilerin girdiği iç ağdaki (Admin Panel) yorumlar bölümünde (Stored XSS).
* **Soru:** Sadece "İkisi de XSS" diyerek geçemeyiz. Bu iki zafiyetin CVSS skorları ve şirkete vereceği zarar (Impact) neden birbirinden tamamen farklıdır? VDP yetkilisine bu iki açığın risk seviyesini nasıl kıyaslayarak açıklarsınız?

**2. Çözüm Üretmek (Mitigation):**
*Senaryo:* Yazılım ekibi size geri dönüş yaptı: *"Bize SQL Injection açığını bulduğun için teşekkür ederiz. Arama kutusuna girilen ' (tek tırnak) karakterini yasaklayarak açığı kapattık."*
* **Soru:** Bir mühendis olarak, sadece tırnak işaretini (veya belirli kelimeleri) yasaklamanın (Blacklisting) neden kalıcı ve güvenli bir çözüm olmadığını nasıl açıklarsınız? SQLi zafiyetini **kökten** çözmek için yazılımcılara hangi mimari yaklaşımı (Örn: Prepared Statements / Parametrik Sorgular) önermeniz gerekir? Mantığını açıklayın.

---

### 📤 Teslim Formatı ve Kontrol Listesi

Bu rapor, sizin 101 aşamasındaki **Mezuniyet Tezinizdir**. Teslim etmeden önce aşağıdaki maddelerin tamamlandığından emin olun. 

* **Dosya Adı:** `Ad_Soyad_101_Bitirme_Projesi.pdf`
* **Format ve Uzunluk:** PDF Formatı. (Beklenen ideal uzunluk **15 - 20 Sayfa** arasıdır. Gereksiz laf kalabalığından kaçının, maksimum 25 Sayfa).
* **Sayfa Düzeni ve Kontrol Listesi:**
    * [ ] **Kapak Sayfası:** Eğitim Adı, Proje Adı, Adınız Soyadınız ve Tarih.
    * [ ] **İçindekiler Tablosu:** (Uzun bir rapor olacağı için okumayı kolaylaştırmalıdır).
    * [ ] **Faz 1 / Cephe 1 (Linux):** Bandit 11-15 arası şifrelerin ve kullanılan komutların mantıksal açıklamaları.
    * [ ] **Faz 1 / Cephe 2 (Web):** Natas 0-10 arası seviyelerin Burp Suite ekran görüntüleri, kullanılan payload'lar ve zafiyet türleri.
    * [ ] **Faz 1 / Cephe 3 (Ağ):** C2 Carnage odasındaki PCAP analizine ait Wireshark filtre ekran görüntüleri ve zararlı trafik tespitleri.
    * [ ] **Faz 2 (Saha Operasyonu):** Gerçek bir VDP hedefi üzerinde yapılan zafiyet taramasının profesyonel raporu (CVSS Skoru ve Impact açıklaması ile birlikte).
    
* **Yükleme Adımları:** Kendi GitHub reponuzda oluşturacağınız `101-Final` klasörüne PDF dosyanızı yükleyip, ana repoya **Pull Request (PR)** açın.

⚠️ **KRİTİK UYARI:**
Bu proje, kiminle **201 Aşamasına (İleri Seviye Operasyon Timi)** geçeceğimizi belirleyecek **tek unsurdur**. 11 Mart'a kadar olan bu süreyi iyi planlayın. "Vaktim yoktu", "Sınavım vardı" gibi bahaneler kabul edilmez. Sektör, sadece pes etmeyenleri ödüllendirir.

---

### 📚 İpucu Kutusu (Cheat Sheet)

Final operasyonu sırasında 3 farklı cephede savaşırken hayat kurtaracak kritik komutlar ve filtreler:

#### 🐧 Linux / Bash (Bandit İpuçları)
| Komut / Mantık | Açıklama |
| :--- | :--- |
| `ssh -i id_rsa user@hedef` | Parola yerine "Private Key" (Gizli Anahtar) dosyası kullanarak SSH bağlantısı kurar. |
| `nc localhost 30000` | Netcat (nc) kullanarak belirli bir porta bağlanır ve veri gönderip/almanızı sağlar. |
| `xxd` komutu | Binary (İkili) verilerin "Hex Dump" (Onaltılık döküm) halini oluşturur veya tersine çevirir. |
| `tr 'A-Za-z' 'N-ZA-Mn-za-m'` | ROT13 şifreleme mantığıyla metinleri kaydırarak çözer. |

#### 🌐 Web / Burp Suite (Natas İpuçları)
* **LFI (Local File Inclusion):** Sunucudaki yerel bir dosyayı okumaya çalışıyorsanız, URL'deki parametreleri `?file=/etc/natas_webpass/natasX` şeklinde manipüle etmeyi deneyin.
* **Command Injection:** Arama kutularına sistem komutu enjekte etmek için noktalı virgül (`; ls -la`) veya ve/veya operatörlerini (`&& whoami`, `| cat file`) kullanın.
* **Burp Suite Repeater (`Ctrl + R`):** Sayfayı tarayıcıdan sürekli yenilemek yerine, isteği Repeater'a atıp payload'ları oradan çok daha hızlı test edin.

#### 📡 Ağ Analizi / Wireshark (C2 Carnage İpuçları)



* `http.request.method == "POST"`: Ağdaki sadece veri gönderilen (POST edilen) HTTP paketlerini filtreler. Zararlı yazılımlar genellikle verileri C2 sunucusuna POST eder.
* `ip.addr == X.X.X.X`: Sadece şüphelendiğiniz spesifik bir IP adresine giden ve oradan gelen trafiği süzer.
* `dns.qry.name contains "domain"`: Belirli bir kelimeyi içeren DNS sorgularını bulur. Zararlı yazılımın hangi domainlere çıkmaya çalıştığını görmek için idealdir.
* **Dosya Çıkartma:** `File > Export Objects > HTTP` yolunu izleyerek ağ trafiği içinde indirilen zararlı dosyaları (exe, dll) PCAP'ten dışarı aktarabilirsiniz.

**Bildiğiniz her şeyi masaya koyun. Başarılar dileriz.**

*AnkaCORE Operasyon Merkezi* 🦅
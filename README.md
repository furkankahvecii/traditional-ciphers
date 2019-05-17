Tarihteki Şifreleme Yöntemleri
========

Tarihte binlerce yıldan bu yana belirli zaman aralıklarında sayısız şifreleme yöntemi kullanılmıştır.Bu yöntemlerin birçoğu kullanıldığı dönemlerde kırılamayan yöntemler olarak nitelendirilmiş olmasına rağmen zaman içerisinde kendilerine duyulan güveni yitirerek tarih içerisinde yerlerini almışlardır.Genel olarak inceleyecek olursak tarihteki şifreleme yöntemlerinin çoğunun ortak özelliği simetrik olmasıdır.Yani hem şifreleme hem de şifre çözme işlemlerinde kullanılan anahtar değerinin aynı olmasıdır.Bu nedenle günümüz simetrik şifreleme yöntemlerinin sahip olması gereken güvenli anahtar değişimi işleminin tarihsel süreçte geçmiş yöntemler için de geçerli oldugunu bilmek gerekir.

Bu kısım günümüze kadar ulaşmış olan, genellikle zamanında yaygın kullanıma sahip olmuş yöntemlerden bazılarını ve yöntemler hakkında teknik bilgilerin yanı sıra Java programlama dilini kullanarak algoritma yapılarını içerir.

## Polybius Şifreleme Yöntemi

Antik Yunanistan'da askeri ve ticari bilginin güvenli bir şekilde iletimin sağlayabilmek için Yunanlar bazı şifreleme sistemleri geliştirmişlerdi.MÖ 203-120 tarihleri arasında antik Yunanistan'da yaşamış olan Yunan tarihçi Polybius, Polybius dama tahtası denen ve sonraki şifreleme sistemleri için bilinen birçok benzer eleman içeren bir cihaz kullanarak metin şifrelemenin temellerini ortaya koydu.

Polybius dama tahtası, alfabenin harflerini içeren beşe beşlik bir ızgaradan oluşur.Fakat bu izgara kullanılan alfabenin harf sayısına göre istenilen boyularda da(n x m, n x n) tasarlanabilir.Her harfin bulunduğu satır ve sütun değeleri birleştirilip iki basamaklı bir sayı elde edilir.Bu sayı harfin şifrelenmiş halini temsil eder.

## Sezar Şifreleme Yöntemi

Monoalfabetik şifrelemenin tipik bir örneği olan Sezar şifreleme yöntemi tarihin ilk kriptolojik fikirlerinden bir tanesidir. Bu şifreleme yönteminde şifrelenecek metindeki her harfin yerine, kendisinden önceden belirlenmiş kaydırma sayısı kadar sonraki harf kullanılır. Örneğin 3 harf atlamalı Sezar şifrelemede "A" harfi yerine "D" harfi, "B" harfi yerine "E" harfi yazılır.Sezar şifreleme yönteminin harf atlama sayısı değiştirilerek farklı çeşitleri oluşturulabilir.

Sezar şifreleme algoritması oldukça güvensizdir. Çünkü kaba kuvvet(brute force) ataklarıyla kolayca kırılabilir. Şifreleme ve şifre çözme yöntemleri gizli olmadığı gibi,29 harflik Türk alfabesiyle oluşturulmuş bir şifreyi çözmek için 29 farklı deneme yapmak yeterlidir.

## Affine Şifreleme Yöntemi

Affine şifreleme mono alfabetik yerine koymalı şifreleme yöntemlerinin bir çeşididir.Yöntemde öncelikle kullanılacak alfabenin her harfine karşılık bir sayı değeri atanır. Harflere karşılık gelen sayı değerleri bir tabloda tutulur. Bu tablonun karşılıklı iletişim gerçekleştirmek isteyen her iki tarafta da bulunması gerekir.

Şifrelenmek istenen açık mesajın her karakteri için, o karaktere karşılık gelen sayı değeri basit bir matematiksel fonksiyona girdi olarak gönderilir. Fonksiyon sonuç olarak farklı bir sayı değeri çıktısı üretir. Fonksiyondan çıkış olarak üretilen bu sayı değeri, tabloda hangi karakteri temsil ediyorsa o karakter, şifreli mesajın yapısını oluşturur. Affine şifrelemede doğrunun denklemi olan y=ax+b doğrusal fonksiyonu kullanılır.Bu denklemde x açık mesaj, a ve b ikili anahtarı, y ise şifreli mesajı ifade eder.

## Vigenere Şifreleme Yöntemi

Çok alfabeli şifrelemenin basit bir formu olan Vigenere şifreleme, tek alfabeli kaydırma ve yerine koyma şifreleme yöntemlerine dayanan Sezar şifreleme algoritmasının geliştirilmiş bir halidir.Sezar şifrelemede kaydırma ve yerine koyma işlemleri için sadece bir alfabe kullanılırken, Vigenere şifrelemede birden fazla alfabe kullanılır. Böylece şifrelenecek mesajdaki aynı harflerin şifrelenmesi sonucundan farklı harfler ortaya çıkar. Bu durum Vigenere yöntemini Sezar yötemine göre daha güçlü kılar ve yapısının kırılmasını zorlaştırır.

Şifreleme yönteminde öncelikle şifreleme işlemi sırasında kullanılacak anahtar seçilir. Şifrelenecek mesajın harf sayısı anahtar boyutundan büyük ise anahtar tekrar tekrar kullanılabilir. Şifrelenecek mesajın ilk harfi, anahtar değerinin ilk harfinden alfabedeki sırası oranında kaydırılır ve şifreli harf elde edilir. Anahtar değerinin her harfinin sırasına göre şifrelenecek mesajdaki her harf farklı bir alfabe ile şifrelenir ve şifreleme işlemi tamamlanır.

## Playfair Şifreleme Yöntemi

Yöntem ikişerli bloklar halinde çalışır ve aynı anda iki harf değeri şifrelenir. Harflerin birer birer değil de ikişerli olarak şifrelenmesinden dolayı frekans analizi yöntemine karşı oldukça güçlü bir yöntemdir.

Yöntem, İngiliz alfabe yapısına göre şifreleme yapmak için 5x5'lik bir matris kullanır. Fakat farklı boyutlarda da matris kullanılabilir. Matris elemanlarını belirlemek için bir anahtar kelime seçilir. Ardından bu anahtar kelime içerisinde harf tekrarı olmayacak şekilde anahtar değerleri matrise yerleştirilir. Matris de kalan boş yerleri ise sırasıyla alfabedeki diğer harfler yerleştirilir. Böylece matris elde edilmiş olur.

Şifreleme işlemi için üç kural vardır.

   1. İkili bloklar halinde alınan harfler eğer aynı satırda bulunuyorsa harflerin birer sağındaki değerler alınır.
   2. İkili bloklar halinde alınan harfler eğer aynı sütunda bulunuyorsa harflerin birer altındaki değerler alınır.
   3. İkili bloklar halinde alınan harfler ne aynı satırda ne de aynı sütunda ise harfler birer dikdörtgen köşesi gibi düşünülür ve o       harflerin köşelerine karşılık gelen ters köşeler alınır.

Şifre çözme işlemi için bu adımlar tersten uygulanır.

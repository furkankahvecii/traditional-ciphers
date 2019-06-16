Tarihteki Şifreleme Yöntemleri
========

Tarihte binlerce yıldan bu yana belirli zaman aralıklarında sayısız şifreleme yöntemi kullanılmıştır.Bu yöntemlerin birçoğu kullanıldığı dönemlerde kırılamayan yöntemler olarak nitelendirilmiş olmasına rağmen zaman içerisinde kendilerine duyulan güveni yitirerek tarih içerisinde yerlerini almışlardır.Genel olarak inceleyecek olursak tarihteki şifreleme yöntemlerinin çoğunun ortak özelliği simetrik olmasıdır.Yani hem şifreleme hem de şifre çözme işlemlerinde kullanılan anahtar değerinin aynı olmasıdır.Bu nedenle günümüz simetrik şifreleme yöntemlerinin sahip olması gereken güvenli anahtar değişimi işleminin tarihsel süreçte geçmiş yöntemler için de geçerli oldugunu bilmek gerekir.

Bu kısım günümüze kadar ulaşmış olan, genellikle zamanında yaygın kullanıma sahip olmuş yöntemlerden bazılarını ve yöntemler hakkında teknik bilgilerin yanı sıra Java programlama dilini kullanarak yazılmış algoritma yapılarını içerir.

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

## Bifid Şifreleme Yöntemi

1901 yılında ünlü Fransız kriptograf Felix Delastelle tarafından geliştirilmiş bir blok şifreleme yöntemidir. Felix Delastelle aynı zamanda Trifid ve Four-square şifrelemeyi de geliştirmiştir.

Bifid şifreleme yöntemi şifreleme ve şifre çözme işlemlerinde Polybius dama tahtasını kullanır. Polybius dama tahtası bir matristir. Şifreli mesajın her bir harfi bu matris yardımıyla bir çift sayısal ifadeye dönüştürülür. Anahtar değeri kullanılan alfabe matrisinin kendisidir, bu nedenle mesajlaşacak taraflarda aynı alfabe matrisinin bulunması gerekir. Bifid şifreleme yöntemi için alfabedeki harf sayısına göre en uygun boyutta bir kare matris kullanılmalıdır.

Dikkat edilmesi gereken şeylerden biri soldan sağa ikili okumada sorun yaşanmaması için şifrelenecek mesajın ikinin katı uzunluğunda olması gerektiğidir. İkinin katı olması için mesaj uzunluğunun modu alınarak kalan sonuç değeri miktarınca mesaj üzerine harf ekleme işlemi yapılabilir.

Şifre çözme işlemi şifrelemenin tam tersidir. Bu işlemde şifreli mesaj harflerine ayrılarak her harfin adres değeri çıkartılır ve bu değerler iki satırlı matris üzerine soldan sağa dogru yazlarak yerleştirlir. Ardından her sütun değeri yukarıdan aşağıya okunarak açık mesajın adres değerleri elde edilir. Bu adreslerde bulunan harfler birleştirilerek açık mesaj ele edilir.

## Trifid Şifreleme Yöntemi

Fransız kriptograf Felix Delastelle tarafından geliştirilmiş bir blok şifreleme yöntemidir. Trifid şifreleme Bifid şifreleme yönteminin üç boyuta taşınmış halidir. Bu nedenle Bifid şifreleme yöntemiyle büyük bir benzerlik taşımaktadır. Şifreleme işlemi için kullanılan alfabenin harfleri 3x3x3 boyutunda bir küpün üzerine yerleştirilir.Küp içerisine yerleştirilen her harfin üç boyutlu bir adres değeri vardır. Bu adres değeri x,y ve z koordinatlarının birleşiminden oluşur.

Şifrelenecek mesaj harflerine ayrılır ve her harfin adres değeri çıkartılır. Adres değerleri yukarıdan aşagı doğru yazılarak üç satırlı bir matris elde edilir. Ardından matris üzerinde soldan sağa üçerli okuma yapılır ve şifreli adres değerleri elde edilir. Bu adres değerlerinin temsil ettiği harfler birleştirilerek şifreli mesaj elde edilir.

Bu noktada dikkat edilmesi gereken şey soldan sağa üçerli okumada sorun yaşanmaması için şifrelenecek mesajın üçün katı uzunluğunda olması gerektiğidir. Üçün katı olması için mesaj uzunluğunun modu alınarak kalan sonuç değeri miktarınca mesaj üzerine harf ekleme işlemi yapılabilir.

Şifre çözme işlemi Bifid şifreleme yönteminde olduğu gibi şifreleme işleminin tam tersidir. Bu işlemde şifreli mesaj harflerine ayrılarak her harfin adres değeri çıkartılır ve bu değerler üç satırlı matris üzerine soldan sağa doğru yazılarak yerleştirilir. Ardından her sütun değeri yukarıdan aşagıya okunarak açık mesaj harflerinin adres değerleri elde edilir. Bu adreslerde bulunan harfler birleştirilerek açık mesaj elde edilir.

## Vernam Şifreleme Yöntemi

Amerikan Telefon ve Telgraf şirketinde mühendis olarak çalışan Gilbert Vernam 1.Dünya Savaşı sırasında Almanların çözemeyeceği bir şifreleme metodunu icat etmekle görevlendirilmişti. Bu görevi yerine getirmek üzere Gilbert Vernam, Joseph Mauborgne isimli bir subay ile birlikte 1917 yılında bir şifreleme yöntemi geliştirdiler.

Vernam adı verdikleri dizi şifreleme yönteminde açık mesajı şifrelemek için mesaj ile aynı uzunlukta ya da mesajdna daha uzun bir anahtar(tek kullanımlık şerit) kullanılır.

Sistemin güvenliği rastgele üretilen anahtar değerine bağlıdır.Anahtar her seferinde yeniden üretildiği, bir kereye mahsus kullanıldığı,kısmen ya da tamamen tekrar kullanılmadığı ve gizli tutulduğu takdirde bu şifrele yöntemini kırmanın imkansız olduğu kanıtlanmıştır.

Vernam şifreleme birçok şifreleme yöntemiyle karşılaştırıldığında oldukça basittir.Açık mesaj içinde yer alan her karakter, üretilen anahtarda karşısına denk gelen karakterle XOR(özel veya) işlemine sokularak şifreli mesaj elde edilir.

Şifreli Metin = Açık Metin ^ Anahtar ( ^ = XOR)

Mesajı çözmek için rastgele anahtarın bilinmesi yani gönderici tarafa açık mesajı şifrelemede kullanılan anahtar değerinin alıcı tarafta da bulunması gerekir. Bu nedenle hem gönderici hem alıcı tarafta olmak üzere anahtar değerinin iki kopyasına ihtiyaç vardır.Şifreli mesaj içinde yer alan her karakter, anahtarda karşısına denk gelen karakterle yeniden XOR işlemine sokulduğunda açık mesaj elde edilir.

Açık Metin = Şifreli Metin ^ Anahtar

## Hill Şifreleme Yöntemi

Hill şifreleme lineer cebire dayanan bir blok şifreleme yöntemidir.1929 yılında Lester S. Hill tarafından geliştirilmiştir. Hill şifreleme yönteminde şifrelenecek mesaj belirli uzunluklarda bloklara ayrılır ve şifrelenir.Tüm blokların şifrelenip bir araya getirilmesinin ardından şifreli mesaj elde edilir.

Hill şifreleme yöntemi matris işlemlerine dayanır.Şifreleme işlemi için  anahtar değeri olarak n x n’lik bir kare matrisin kullanılması gerekir. Kullanılacak anahtar matrisi, şifrelenecek mesajda her bloğun kaç karakterden oluşacağını belirler.Seçilen n x n’lik anahtar matrisi için her blokta şifrelenecek karakter sayısı n olacaktır.

Kullanılacak anahtar matrisin mod sayısına göre terslenebilen bir matris olması gerekir.Mod sayısı kullanılan alfabeye göre belirlenen bir sayıdır.Şifrelenecek mesaj ve anahtar matrisi belirlendikten sonra anahtar matrisinin boyutuna bağlı olarak mesaj bloklara ayrılır.Her karakter değeri için o değere karşılık gelen sayı değeri yazılır.Anahtar değeri ile ikili bloklar çarpma işlemine tabi tutulur.Çıkan sonuç değerleri mod değerinden büyük olduğundan mod 26(alphabet.length) işlemine tabi tutulur.Bulunan sonuç değerlerinin harf tablosundaki karşılıkları bize şifreli mesajı verir.

Şifreli Metin = (Açık Metin x Anahtar Matrisi) Mod 26 	

Alıcı tarafa şifre çözme işlemi için öncelikle anahtar matris değerinin tersinin alınması gerekir. Bu işlemin ardından şifreli mesaj, ikili bloklar halinde anahtar değerinin tersi ile çarpma işlemine tabi tutulur.Çıkan sonuç değeri 26’dan büyük ise mod alınır.Bulunan sonuç değerlerinin harf tablosundaki karşılıkları bize açık mesajı verir.

Açık Metin = (Açık Metin x Anahtar Matrisinin Tersi) Mod 26
 

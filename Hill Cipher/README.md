## Hill Şifreleme Yöntemi

Hill şifreleme lineer cebire dayanan bir blok şifreleme yöntemidir.1929 yılında Lester S. Hill tarafından geliştirilmiştir. Hill şifreleme yönteminde şifrelenecek mesaj belirli uzunluklarda bloklara ayrılır ve şifrelenir.Tüm blokların şifrelenip bir araya getirilmesinin ardından şifreli mesaj elde edilir.

Hill şifreleme yöntemi matris işlemlerine dayanır.Şifreleme işlemi için  anahtar değeri olarak n x n’lik bir kare matrisin kullanılması gerekir. Kullanılacak anahtar matrisi, şifrelenecek mesajda her bloğun kaç karakterden oluşacağını belirler.Seçilen n x n’lik anahtar matrisi için her blokta şifrelenecek karakter sayısı n olacaktır.

Kullanılacak anahtar matrisin mod sayısına göre terslenebilen bir matris olması gerekir.Mod sayısı kullanılan alfabeye göre belirlenen bir sayıdır.Şifrelenecek mesaj ve anahtar matrisi belirlendikten sonra anahtar matrisinin boyutuna bağlı olarak mesaj bloklara ayrılır.Her karakter değeri için o değere karşılık gelen sayı değeri yazılır.Anahtar değeri ile ikili bloklar çarpma işlemine tabi tutulur.Çıkan sonuç değerleri mod değerinden büyük olduğundan mod 26(alphabet.length) işlemine tabi tutulur.Bulunan sonuç değerlerinin harf tablosundaki karşılıkları bize şifreli mesajı verir.

Şifreli Metin = (Açık Metin x Anahtar Matrisi) Mod 26 	

Alıcı tarafa şifre çözme işlemi için öncelikle anahtar matris değerinin tersinin alınması gerekir. Bu işlemin ardından şifreli mesaj, ikili bloklar halinde anahtar değerinin tersi ile çarpma işlemine tabi tutulur.Çıkan sonuç değeri 26’dan büyük ise mod alınır.Bulunan sonuç değerlerinin harf tablosundaki karşılıkları bize açık mesajı verir.

Açık Metin = (Şifreli Metin x Anahtar Matrisinin Tersi) Mod 26

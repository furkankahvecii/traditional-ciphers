## Vernam Şifreleme Yöntemi

Amerikan Telefon ve Telgraf şirketinde mühendis olarak çalışan Gilbert Vernam 1.Dünya Savaşı sırasında Almanların çözemeyeceği bir şifreleme metodunu icat etmekle görevlendirilmişti. Bu görevi yerine getirmek üzere Gilbert Vernam, Joseph Mauborgne isimli bir subay ile birlikte 1917 yılında bir şifreleme yöntemi geliştirdiler.

Vernam adı verdikleri dizi şifreleme yönteminde açık mesajı şifrelemek için mesaj ile aynı uzunlukta ya da mesajdan daha uzun bir anahtar(tek kullanımlık şerit) kullanılır.

Sistemin güvenliği rastgele üretilen anahtar değerine bağlıdır.Anahtar her seferinde yeniden üretildiği, bir kereye mahsus kullanıldığı,kısmen ya da tamamen tekrar kullanılmadığı ve gizli tutulduğu takdirde bu şifrele yöntemini kırmanın imkansız olduğu kanıtlanmıştır.

Vernam şifreleme birçok şifreleme yöntemiyle karşılaştırıldığında oldukça basittir.Açık mesaj içinde yer alan her karakter, üretilen anahtarda karşısına denk gelen karakterle XOR(özel veya) işlemine sokularak şifreli mesaj elde edilir.

Şifreli Metin = Açık Metin ^ Anahtar ( ^ = XOR)

Mesajı çözmek için rastgele anahtarın bilinmesi yani gönderici tarafa açık mesajı şifrelemede kullanılan anahtar değerinin alıcı tarafta da bulunması gerekir. Bu nedenle hem gönderici hem alıcı tarafta olmak üzere anahtar değerinin iki kopyasına ihtiyaç vardır.Şifreli mesaj içinde yer alan her karakter, anahtarda karşısına denk gelen karakterle yeniden XOR işlemine sokulduğunda açık mesaj elde edilir.

Açık Metin = Şifreli Metin ^ Anahtar

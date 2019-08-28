## Trifid Şifreleme Yöntemi

Fransız kriptograf Felix Delastelle tarafından geliştirilmiş bir blok şifreleme yöntemidir. Trifid şifreleme Bifid şifreleme yönteminin üç boyuta taşınmış halidir. Bu nedenle Bifid şifreleme yöntemiyle büyük bir benzerlik taşımaktadır. Şifreleme işlemi için kullanılan alfabenin harfleri 3x3x3 boyutunda bir küpün üzerine yerleştirilir.Küp içerisine yerleştirilen her harfin üç boyutlu bir adres değeri vardır. Bu adres değeri x,y ve z koordinatlarının birleşiminden oluşur.

Şifrelenecek mesaj harflerine ayrılır ve her harfin adres değeri çıkartılır. Adres değerleri yukarıdan aşagı doğru yazılarak üç satırlı bir matris elde edilir. Ardından matris üzerinde soldan sağa üçerli okuma yapılır ve şifreli adres değerleri elde edilir. Bu adres değerlerinin temsil ettiği harfler birleştirilerek şifreli mesaj elde edilir.

Bu noktada dikkat edilmesi gereken şey soldan sağa üçerli okumada sorun yaşanmaması için şifrelenecek mesajın üçün katı uzunluğunda olması gerektiğidir. Üçün katı olması için mesaj uzunluğunun modu alınarak kalan sonuç değeri miktarınca mesaj üzerine harf ekleme işlemi yapılabilir.

Şifre çözme işlemi Bifid şifreleme yönteminde olduğu gibi şifreleme işleminin tam tersidir. Bu işlemde şifreli mesaj harflerine ayrılarak her harfin adres değeri çıkartılır ve bu değerler üç satırlı matris üzerine soldan sağa doğru yazılarak yerleştirilir. Ardından her sütun değeri yukarıdan aşagıya okunarak açık mesaj harflerinin adres değerleri elde edilir. Bu adreslerde bulunan harfler birleştirilerek açık mesaj elde edilir.

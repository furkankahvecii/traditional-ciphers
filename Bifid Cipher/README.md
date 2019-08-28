## Bifid Şifreleme Yöntemi

1901 yılında ünlü Fransız kriptograf Felix Delastelle tarafından geliştirilmiş bir blok şifreleme yöntemidir. Felix Delastelle aynı zamanda Trifid ve Four-square şifrelemeyi de geliştirmiştir.

Bifid şifreleme yöntemi şifreleme ve şifre çözme işlemlerinde Polybius dama tahtasını kullanır. Polybius dama tahtası bir matristir. Şifreli mesajın her bir harfi bu matris yardımıyla bir çift sayısal ifadeye dönüştürülür. Anahtar değeri kullanılan alfabe matrisinin kendisidir, bu nedenle mesajlaşacak taraflarda aynı alfabe matrisinin bulunması gerekir. Bifid şifreleme yöntemi için alfabedeki harf sayısına göre en uygun boyutta bir kare matris kullanılmalıdır.

Dikkat edilmesi gereken şeylerden biri soldan sağa ikili okumada sorun yaşanmaması için şifrelenecek mesajın ikinin katı uzunluğunda olması gerektiğidir. İkinin katı olması için mesaj uzunluğunun modu alınarak kalan sonuç değeri miktarınca mesaj üzerine harf ekleme işlemi yapılabilir.

Şifre çözme işlemi şifrelemenin tam tersidir. Bu işlemde şifreli mesaj harflerine ayrılarak her harfin adres değeri çıkartılır ve bu değerler iki satırlı matris üzerine soldan sağa dogru yazlarak yerleştirlir. Ardından her sütun değeri yukarıdan aşağıya okunarak açık mesajın adres değerleri elde edilir. Bu adreslerde bulunan harfler birleştirilerek açık mesaj ele edilir.

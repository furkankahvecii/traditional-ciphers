## Playfair Şifreleme Yöntemi

Yöntem ikişerli bloklar halinde çalışır ve aynı anda iki harf değeri şifrelenir. Harflerin birer birer değil de ikişerli olarak şifrelenmesinden dolayı frekans analizi yöntemine karşı oldukça güçlü bir yöntemdir.

Yöntem, İngiliz alfabe yapısına göre şifreleme yapmak için 5x5'lik bir matris kullanır. Fakat farklı boyutlarda da matris kullanılabilir. Matris elemanlarını belirlemek için bir anahtar kelime seçilir. Ardından bu anahtar kelime içerisinde harf tekrarı olmayacak şekilde anahtar değerleri matrise yerleştirilir. Matris de kalan boş yerleri ise sırasıyla alfabedeki diğer harfler yerleştirilir. Böylece matris elde edilmiş olur.

Şifreleme işlemi için üç kural vardır.

   1. İkili bloklar halinde alınan harfler eğer aynı satırda bulunuyorsa harflerin birer sağındaki değerler alınır.
   2. İkili bloklar halinde alınan harfler eğer aynı sütunda bulunuyorsa harflerin birer altındaki değerler alınır.
   3. İkili bloklar halinde alınan harfler ne aynı satırda ne de aynı sütunda ise harfler birer dikdörtgen köşesi gibi düşünülür ve o       harflerin köşelerine karşılık gelen ters köşeler alınır.

Şifre çözme işlemi için bu adımlar tersten uygulanır.

## Product Entity
# Entity ->> productName, productCategory, productPrice, productUnitlnStock, productDescription
# Temel CRUD metotlarının implement edilmesi gerekiyor. (findAll, save, delete, deleteById...) ->> IService interface'i oluşturuyoruz. Servislere implemente edelim

# Ürün ismine göre ürünü bulunuz.
# Ürün isminin içerdiği harf veya kelimeye göre ürünü bulunuz. 
    List<Ogrenci> findAllByAdLike(String ad);
# Belirli fiyat aralığındaki ürünleri listeleyiniz.
    List<Ogrenci> findAllByYasBetween(Integer start, Integer end);

# Girilen fiyatın üstündeki ürünleri listeleyiniz.
# Belirli bir stok adedinin üzerindeki ürünleri listeleyiniz.
# Belirli bir fiyata eşit ve bu fiyatın üstündeki ürünleri listeleyiniz.
# Bir kategoriye ait kaç adet ürün olduğunu listeleyiniz.
# Bir üründen kaç tane olduğunu listeleyiniz.
# Girilen kategorinin varlığını kontrol ediniz. (true,false)
# Kategorisi 'null' olan ürünleri listeleyiniz.
# Baş harfi girilen kategoriye ait ürünleri listeleyiniz.
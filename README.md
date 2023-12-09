# KLU NESNEYE YÖNELİK PROGRAMLAMA KISA SINAV 1.2

**Bu çalışma Bahar Üründiker (1220505018) ve Eminenur Zengin (1220505056) tarafından birlikte hazırlanmıştır.** 

Çalışmamız Java üzerinde tasarlanmış bir buton uygualasıdır ve arayüzü bulunmaktadır.Uygulamamız çalıştırığında Ekranımıza 4x4'lük bir buton arayüzü çıkmaktadır ve bu butonlar yazdığımız algoritma üzerinden **aktif** ve **pasif** durumlara geçmektedir.Bastığımız ilk buton royal butonu olmakta ve aktif hale gelmektedir.Royal butonu ve ondan sonra bastığımız butonlar aktif duruma geçmekte ve royal butonuna ikinci defa basana dek bu butonlar aktif olmaktadır.Royal butonuna ikinci defa bastığımızda royal butonu dahil bütün butonlar pasif hale gelmektedir.Kodumuzda rahatça anlaşılabilecek yorum satırları bulunmaktadır.

![buton 1](https://github.com/EminenurZengin/1220505056/assets/122752872/87c4be34-eb13-4253-80c6-8ad80c95a6a8)
![buton2](https://github.com/EminenurZengin/1220505056/assets/122752872/77328c35-501a-48a8-9453-6cd469177791)
![buton3](https://github.com/EminenurZengin/1220505056/assets/122752872/67d82d24-7755-4845-9080-9d1a7709e141)
![Custom-Button-Frame-2023-12-10-01-15-21](https://github.com/EminenurZengin/1220505056/assets/122752872/d93e9795-b205-4b81-8d71-8f4f78063aa6)


kodumuzun çıktısı da bu şekildedir.

_Çalışmamız için lazım olan kütüphanelerin kurulumu hakkında bilgi_

Apache Maven, Java tabanlı projelerin yönetimini ve derlenmesini kolaylaştırmak için kullanılan bir proje yönetim aracıdır. Maven, birçok farklı proje yapılandırma ve bağımlılık yönetimi görevini otomatikleştirmek amacıyla geliştirilmiştir. Maven, proje yapılandırmasını XML tabanlı bir dosya olan pom.xml dosyası üzerinden gerçekleştirir. GraphQL’i kullanabilmemiz için de Maven’s ihtıyacımız var. 

[Yükleme Linki](https://phoenixnap.com/kb/install-maven-windows) 

Maven projenizin pom.xml dosyasına GraphQL bağımlılıklarını ekleyin. GraphQL bağımlılıklarını eklemek için projenizin dependencies bölümünü düzenleyebilirsiniz. 

Bu kısımda GraphQL’i kullanabilmek için pom.xml kısmına GraphQL’in bir takım gereklı kodlar eklemelisiniz. Örnek Olarak: 

``` 

 <dependency> 

  <groupId>com.graphql-java</groupId> 

   <artifactId>graphql-java</artifactId> 

   <version>17.5</version> 

   </dependency> 

```
``` 
<dependency>
            <groupId>com.squareup.okhttp3</groupId>
            <artifactId>okhttp</artifactId>
            <version>4.10.0</version>

 </dependency>
``` 
Son yıllarda uygulama geliştirme çok karmaşık bir hale gelmiş bulunmakta.Veritabanından sadece bazı verileri çekip görüntülemekle yetinilmemekte. Bu zamanın geliştiricilerini karmaşık ve veri bakımından zengin kullanıcı arayüzleri oluşturmaya ağırlık vermektedirler.Bu sepeble genel olarak kullanılan API’ler çok zahmetli olmaya başlamaktadır. GraphQL bu sorunlarla başa çıkmak üzere tasarlanmıştır. GraphQL sunucuları, Haskell, JavaScript, Perl, Python, Ruby, Java, C++, C#, Scala, Go, Erlang, PHP ve R dahil olmak üzere birden fazla dilde mevcuttur. 

GraphQL, istemci-sunucu iletişimine modern bir yaklaşımda bulunmaktadır ve geliştiriciler için zengin bir tasarlama ortamı oluşturmak için ortam hazırlanmıştır. İstemciye `istediği veriyi sorgulama ve sorma  özgürlüğü ` tanınmaktadır. Bu özellik kullanıcıların sadece ihtiyacı olan veriyi alabilmelerine olanak sağlayıp gereksiz verilerle uğraşmamalarını sağlar.Aynı zamanda bu şekilde performans artışını ve ağ trafiğinin düzenlenmesini sağlar. 

Kullanıcının daha rahat ve geniş bir kontrol düzeni elde etmesine yardımcı olur.Kullanıcı istediği durmda yeni alanlar ekleyebilir ya da var olan alanları değiştirebilir.Bu şekilde kullanıcının performansını arttırır ve zaman kaybını minimum seviyeye düşürür. AyrıcaGraphQL perspektifinden baktığımızda endpoint karmaşalarıyla karşılaşmıyoruz.GraphQL sorguları bekleyen tek bir endpoint bizi karşılıyor.Burada tüm taleplerimizi yerine getirmemiz gerekiyor.Ayrıca aynı sorguda birden fazla veriyi alma olanağımız da var. 

Her sorgulama dilinde olduğu gibi GraphQL’in de kendine özgü terimleri bulunmaktadır.Bu GraphQL özgü terimleri dört ana başlık altında toplayabiliriz. Bunlar `Query(Sorgu)`, `Mutation(Mutasyon) `,`Subscription(Abonelik)` ve `Schema(Şema)`. 

API geliştiricileri, müşterilerin bu hizmet aracılığıyla sorgulayabileceği tüm olası verileri açıklayan bir şema oluşturmak için GraphQL'i kullanır.GraphQL şeması, hangi tür nesneyi isteyebileceğinizi ve bu nesnenin hangi alanlara sahip olduğunu tanımlayan nesne türlerinden oluşur. Sorgular geldikçe GraphQL sorguları şemaya göre doğrular. GraphQL daha sonra doğrulanmış sorguları yürütür.API geliştiricisi şemadaki her alanı çözümleyici adı verilen bir işleve ekler. Yürütme sırasında, değeri üretmek için çözümleyici çağrılır. 

Facebook, kullanıcı verilerini daha etkili bir şekilde almak ve yönetmek amacıyla RESTful API'lerin yerine daha kullanışlı bir çözüm arayışında bulunmaktaydı ve bu sayede GraphQL ortaya çıktı. React'a benzer şekilde GraphQL, 2012 yılında Facebook tarafından dahili olarak geliştirildi ve 2015 yılında halka açık hale getirildi. GraphQL'in açık kaynak haline getirilmesinin ardından, GraphQL projesi Facebook'tan, Linux Vakfı'nın ev sahipliği yaptığı yeni kurulan GraphQL Vakfı'na taşındı (2018).  

Peki bu kadar bilgiden sonra şunu da unutmadan geçmeyelim.GraphQL’in dezavantajları nelerdir peki? 

- GraphQL, veri sorgulama işinin çoğunu sunucu tarafına kaydırır ve bu da sunucu geliştiricileri için karmaşıklık katar. 
 
- GraphQL, nasıl uygulandığına bağlı olarak, özellikle hız limitleri ve fiyatlandırma göz önüne alındığında, REST API'lerden farklı API yönetim stratejileri gerektirebilir.Bu da Rest API’lere alışkın olan geliştiriciler için bir zorlanma süreci ortaya çıkarır. 

- Önbellek işlemleri, REST'e göre daha karmaşıktır.API geliştiricilernin sürdürülebilir GraphQL şeması yazma gibi ek görevleri vardır. 

- Kullanıcılara geniş bir esneklik sunar, ancak bu, bilinçsizce yapılan sorguların güvenlik sorunlarına neden olabileceği anlamına gelir. Doğru güvenlik önlemlerinin alınması, sorguların ve mutasyonların kontrol edilmesi önemlidir. 

- GraphQL, genellikle tek bir endpoint üzerinden hizmet verir. Bu durum, RESTful API'lerde olduğu gibi farklı kaynaklara farklı endpoint'ler üzerinden erişim sağlamak yerine tek bir endpoint iletişimini içerir. Bu, bazı durumlarda ölçeklendirme ve izleme zorluklarına neden olabilir. 

Bunlar bazı avantajların bile doğru kullanılamadığı durumlarda dezavantaja dönüşebileceğini ifade eder.Her durum avantaja sahip olduğu gibi bir dezavantaj da teşkil edebilir.Her bir dezavantaj, projenin özelliklerine,geliştiricilerin deneyimine ve kullanım durumlarına bağlı olarak değişebilmektedir.

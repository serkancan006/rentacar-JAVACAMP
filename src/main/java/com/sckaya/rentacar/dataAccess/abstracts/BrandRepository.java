package com.sckaya.rentacar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sckaya.rentacar.Entities.concretes.Brand;

// @Repository  ile de kullanabilirsin ioc ye eklemek için
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    // Spring jpa key word den araştır. burada exists kelimesini görünce brand içindeki name e bakara bize direk boollean değeri bulur verdiğimiz isme göre yani kısaca kendisi çözümlemiş olur mesela findByName deseydik brand içindeki name fieldına  a göre yani sütunununa göre o isme ait veriyi bulur ve döndürürü bunu yaptıüımızda Brand nesnnesini geri dönmeliyiz!!!.
    boolean existsByName(String name);
}

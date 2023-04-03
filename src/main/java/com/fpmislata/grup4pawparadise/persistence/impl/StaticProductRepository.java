package com.fpmislata.grup4pawparadise.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import com.fpmislata.grup4pawparadise.business.entity.Product;
import com.fpmislata.grup4pawparadise.persistence.ProductRepository;

public class StaticProductRepository implements ProductRepository{

    List<Product>products = List.of(
        new Product(1, 1, "Sudadera", "23.90",10, "Sudadera para mantener el lomo calentito."),
        new Product(2, 1, "Chubasquero", "25.90",20, "Chubasquero impermeable para volver a casa tan seco como la mojama."),
        new Product(3, 1, "Botas", "16.90",5, "Botas para chapotear sin mojarse las patitas."),
        new Product(4, 1, "Jersey", "15.90",30, "Jersey suave de lana merino para trotar por el campo sin pasar frio."),
        new Product(5, 2, "correa running", "19.99", 3, "Correa flexible con cinturón para correr sin parar."),
        new Product(6, 2, "Arnés GoPro", "30.95", 3, "Arnés para ajustar tu cámara GoPro y descubrir como ve el mundo de tu mascota."),
        new Product(7, 2, "Collar luminoso", "14.95", 30, "Collar para brillar con luz propia."),
        new Product(8, 2, "Collar GPS", "84.95", 15, "Collar con GPS para saber en todo momento donde está tu fugitivo favorito."),
        new Product(9, 3, "Casco moto", "15.99", 10, "Casco molón para proteger su cabezón."),
        new Product(10, 3, "Mochila porta mascotas", "45.99", 15, "Mochila para transportar a tu mascota, viajaréis mas unidos que nunca."),
        new Product(11, 3, "Cinturón seguridad coche", "5.99", 40, "Cinturón con el que evitar una multa segura."),
        new Product(12, 3, "Asiento coche", "39.09", 5, "Asiento de seguridad para el coche para que tu mascota disfrute de cada trayecto."),
        new Product(13, 4, "Botella multifunción", "15.00", 5, "Botella multusos con un compartimento para pienso, otro para agua y bebedero."),
        new Product(14, 4, "Cama portátil", "35.00", 5, "Cama la mar de enrollada."),
        new Product(15, 4, "Pack portátil de juguetes", "16.50", 5, "Pack de juguetes recogido en un práctico saco."),
        new Product(16, 4, "Piscina desmontable", "45.00", 5, "Piscina con la que tu mascota disfrutará todo el verano.")
    );

    @Override
    public List<Product> getAll() {
        return this.products;
    }

    @Override
    public Product findById(int id) throws Exception{
        for (Product product : this.products) {
            if (product.getId() == id ) {
                return product;
            }  
        }
        throw new Exception("Producto no encontrado.");  
    }

    @Override
    public List<Product> findByCategoryId(int categoryId) {

        List<Product> products = new ArrayList<>();

        for (Product product : this.products) {
            if (product.getCategoryId() == categoryId ) {
                products.add(product);
            }  
        }
        return products; 
    }
    
}

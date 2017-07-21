package com.trabajoweb.primero.visual;

import com.trabajoweb.primero.clases.Estudiante;
import com.trabajoweb.primero.clases.EstudiantesRepository;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Maco on 20/07/2017.
 */
@SpringUI
public class App extends UI {
    @Autowired
    EstudiantesRepository estudiantesRepository;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout layout =new VerticalLayout();

        TextField nombre =new TextField("nombre:");
        TextField edad =new TextField("edad:");

        Grid<Estudiante> grid=new Grid<>();
        grid.addColumn(Estudiante::getId).setCaption("id");
        grid.addColumn(Estudiante::getNombre).setCaption("nombre");
        grid.addColumn(Estudiante::getEdad).setCaption("edad");

        Button add=new Button("Agregar");
        add.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Estudiante uni=new Estudiante();
                uni.setNombre(nombre.getValue());
                uni.setEdad(Integer.parseInt(edad.getValue()));

                estudiantesRepository.save(uni);
                grid.setItems(estudiantesRepository.findAll());

                Notification.show("Adicionado correctamente");
                nombre.clear();
                edad.clear();
            }
        });
        layout.addComponents(nombre,edad,add);
        layout.addComponents(grid);
        setContent(layout);

    }
}



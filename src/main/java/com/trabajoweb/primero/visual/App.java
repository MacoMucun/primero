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
        HorizontalLayout layout = new HorizontalLayout();

        TextField nombre = new TextField("nombre:");
        TextField puesto = new TextField("puesto:");
        TextField edad = new TextField("edad:");
        TextField dpi = new TextField("dpi:");

        VerticalLayout layout1= new VerticalLayout();
        Grid<Estudiante> grid=new Grid<>();
        grid.addColumn(Estudiante::getId).setCaption("id");
        grid.addColumn(Estudiante::getNombre).setCaption("nombre");
        grid.addColumn(Estudiante::getPuesto).setCaption("puesto");
        grid.addColumn(Estudiante::getEdad).setCaption("edad");
        grid.addColumn(Estudiante::getDpi).setCaption("dpi");

        Button add=new Button("Ingresar los datos");
        add.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Estudiante uni=new Estudiante();
                uni.setNombre(nombre.getValue());
                uni.setPuesto(puesto.getValue());
                uni.setEdad(Integer.parseInt(edad.getValue()));
                uni.setDpi(Integer.parseInt(dpi.getValue()));

                estudiantesRepository.save(uni);
                grid.setItems(estudiantesRepository.findAll());

                Notification.show("Se ingreso correctamente los datos");
                nombre.clear();
                edad.clear();
                puesto.clear();
                dpi.clear();
            }
        });
        layout.addComponents(nombre,puesto,edad,dpi,add);
        layout.addComponents(grid);
        setContent(layout);

    }
}



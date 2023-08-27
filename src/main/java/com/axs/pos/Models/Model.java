package com.axs.pos.Models;


import com.axs.pos.Views.ViewFactory;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;

    private Model(){
        this.viewFactory = new ViewFactory();
        System.out.println("execute Model");
    }
    public static synchronized Model getInstance(){
        if(model == null){
            model = new Model();
            System.out.println("new model");
        }
        return model;
    }
    public ViewFactory getViewFactory(){
        return viewFactory;
    }
}

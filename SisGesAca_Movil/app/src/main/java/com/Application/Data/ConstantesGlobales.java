package com.Application.Data;

public class ConstantesGlobales {

    public static final int LARGA_DURACION = 1;
    public static final int CORTA_DURACION = 2;

    public static final int MODO_AGREGAR = 1;
    public static final int MODO_EDITAR = 2;

    public static String apiURL_getCarreras = "http://10.0.2.2:8080/SisGesAca_Web/api/carrera/listar?id=";
    public static String apiURL_getCarrera = "http://10.0.2.2:8080/SisGesAca_Web/api/carrera/buscar?id=";
    public static String apiURL_postCarrera = "http://10.0.2.2:8080/SisGesAca_Web/api/carrera/insertar";
    public static String apiURL_putCarrera = "http://10.0.2.2:8080/SisGesAca_Web/api/carrera/modificar";
    public static String apiURL_deleteCarrera = "http://10.0.2.2:8080/SisGesAca_Web/api/carrera/eliminar?id=";

    public static String apiURL_getCursos = "http://10.0.2.2:8080/SisGesAca_Web/api/curso/listar?id=";
    public static String apiURL_getCurso = "http://10.0.2.2:8080/SisGesAca_Web/api/curso/buscar?id=";
    public static String apiURL_postCurso = "http://10.0.2.2:8080/SisGesAca_Web/api/curso/insertar";
    public static String apiURL_putCurso = "http://10.0.2.2:8080/SisGesAca_Web/api/curso/modificar";
    public static String apiURL_deleteCurso = "http://10.0.2.2:8080/SisGesAca_Web/api/curso/eliminar?id=";

    public static String apiURL_getCiclos = "http://10.0.2.2:8080/SisGesAca_Web/api/ciclo/listar?id=";
}

package Model;

import java.math.BigDecimal;
import java.util.Date;
import java.time.LocalDate;

public class Requerimiento {
    public enum Mes {
        ENERO(1), FEBRERO(2), MARZO(3), ABRIL(4), MAYO(5), JUNIO(6), JULIO(7), AGOSTO(8), SEPTIEMBRE(9), OCTUBRE(10), NOVIEMBRE(11), DICIEMBRE(12);
        private final int numero;

        Mes(int numero) {
            this.numero = numero;
        }

        public static Mes obtenerMesPorNumero(int numero) {
            for (Mes mes : Mes.values()) {
                if (mes.retornarNumero() == numero) return mes;
            }
            throw new IllegalArgumentException("Número de mes inválido");
        }

        public int retornarNumero() {
            return numero;
        }
    }

    public enum EstadoDeTramite {
        AUTORIZADO(1), DESISITIDO(2), NEGADO(3), ENPROCESO(4);
        private final int numero;

        EstadoDeTramite(int numero) {
            this.numero = numero;
        }

        public static EstadoDeTramite obtenerEstadoDeTramitePorNumero(int numero) {
            for (EstadoDeTramite estadoDeTramite : EstadoDeTramite.values()) {
                if (estadoDeTramite.retornarNumero() == numero) return estadoDeTramite;
            }
            throw new IllegalArgumentException("Número de estado de trámite inválido.");
        }

        public int retornarNumero() {
            return numero;
        }
    }

    public enum Prioridad{
        ALTA(1), MEDIA(2), BAJA(3);
        private final int numero;

        Prioridad(int numero) {
            this.numero = numero;
        }

        public static Prioridad obtenerPrioridadPorNumero(int numero) {
            for (Prioridad prioridad : Prioridad.values()) {
                if (prioridad.retornarNumero() == numero) return prioridad;
            }
            throw new IllegalArgumentException("Número de prioridad inválido.");
        }

        public int retornarNumero() {
            return numero;
        }
    }

    private String dictaminador;
    private long numeroDeControl;
    private String RFC;
    private String nombreORazonSocial;
    private String tramite;
    private String tipoDeTramite;
    private Date fechaDeRecepcion;
    private Mes periodo; // MES
    private int ejercicio; // AÑO
    private EstadoDeTramite estadoDeTramite; // AUTORIZADO, DESISITIDO, NEGADO, EN PROCESO
    private Date fechaDeResolucion;
    private BigDecimal importeSolicitado;
    private BigDecimal importeAutorizado;
    private BigDecimal compensacionPorOficio;
    private Date fechaDePago;
    private BigDecimal importePagado;
    private Date fechaDeRequerimiento;
    private Date fechaDeSegundoRequerimiento;
    private Prioridad prioridad;


    public Requerimiento() {
        this.dictaminador = "";
        this.numeroDeControl = 0;
        this.RFC = "";
        this.nombreORazonSocial = "";
        this.tramite = "";
        this.tipoDeTramite = "";
        this.fechaDeRecepcion = new Date();
        this.ejercicio = 0;
        this.fechaDeResolucion = new Date();
        this.importeSolicitado = new BigDecimal(0);
        this.importeAutorizado = new BigDecimal(0);
        this.compensacionPorOficio = new BigDecimal(0);
        this.fechaDePago = new Date();
        this.importePagado = new BigDecimal(0);
        this.fechaDeRequerimiento = new Date();
        this.fechaDeSegundoRequerimiento = new Date();
        this.prioridad = Prioridad.BAJA;
    }

    public Requerimiento(String dictaminador, long numeroDeControl, String RFC, String nombreORazonSocial, String tramite, String tipoDeTramite, BigDecimal importeSolicitado, BigDecimal compensacionPorOficio) {
        this.dictaminador = dictaminador;
        this.numeroDeControl = numeroDeControl;
        this.RFC = RFC;
        this.nombreORazonSocial = nombreORazonSocial;
        this.tramite = tramite;
        this.tipoDeTramite = tipoDeTramite;
        this.importeSolicitado = importeSolicitado;
        this.compensacionPorOficio = compensacionPorOficio;
        this.prioridad = Prioridad.BAJA;

        //
        this.fechaDeRecepcion = new Date();
        this.periodo = Mes.obtenerMesPorNumero(LocalDate.now().getMonthValue());
        this.ejercicio = LocalDate.now().getYear();

        Notificacion();
    }

    public Requerimiento Notificacion() {
        return this;
    }
}

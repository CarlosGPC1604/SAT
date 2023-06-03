package Model;

import java.math.BigDecimal;
import java.util.Calendar;
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

    public String getDictaminador() {
        return dictaminador;
    }

    public void setDictaminador(String dictaminador) {
        this.dictaminador = dictaminador;
    }

    public long getNumeroDeControl() {
        return numeroDeControl;
    }

    public void setNumeroDeControl(long numeroDeControl) {
        this.numeroDeControl = numeroDeControl;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getNombreORazonSocial() {
        return nombreORazonSocial;
    }

    public void setNombreORazonSocial(String nombreORazonSocial) {
        this.nombreORazonSocial = nombreORazonSocial;
    }

    public String getTramite() {
        return tramite;
    }

    public void setTramite(String tramite) {
        this.tramite = tramite;
    }

    public String getTipoDeTramite() {
        return tipoDeTramite;
    }

    public void setTipoDeTramite(String tipoDeTramite) {
        this.tipoDeTramite = tipoDeTramite;
    }

    public Date getFechaDeRecepcion() {
        return fechaDeRecepcion;
    }

    public void setFechaDeRecepcion(Date fechaDeRecepcion) {
        this.fechaDeRecepcion = fechaDeRecepcion;
    }

    public Mes getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Mes periodo) {
        this.periodo = periodo;
    }

    public int getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(int ejercicio) {
        this.ejercicio = ejercicio;
    }

    public EstadoDeTramite getEstadoDeTramite() {
        return estadoDeTramite;
    }

    public void setEstadoDeTramite(EstadoDeTramite estadoDeTramite) {
        this.estadoDeTramite = estadoDeTramite;
    }

    public Date getFechaDeResolucion() {
        return fechaDeResolucion;
    }

    public void setFechaDeResolucion(Date fechaDeResolucion) {
        this.fechaDeResolucion = fechaDeResolucion;
    }

    public BigDecimal getImporteSolicitado() {
        return importeSolicitado;
    }

    public void setImporteSolicitado(BigDecimal importeSolicitado) {
        this.importeSolicitado = importeSolicitado;
    }

    public BigDecimal getImporteAutorizado() {
        return importeAutorizado;
    }

    public void setImporteAutorizado(BigDecimal importeAutorizado) {
        this.importeAutorizado = importeAutorizado;
    }

    public BigDecimal getCompensacionPorOficio() {
        return compensacionPorOficio;
    }

    public void setCompensacionPorOficio(BigDecimal compensacionPorOficio) {
        this.compensacionPorOficio = compensacionPorOficio;
    }

    public Date getFechaDePago() {
        return fechaDePago;
    }

    public void setFechaDePago(Date fechaDePago) {
        this.fechaDePago = fechaDePago;
    }

    public BigDecimal getImportePagado() {
        return importePagado;
    }

    public void setImportePagado(BigDecimal importePagado) {
        this.importePagado = importePagado;
    }

    public Date getFechaDeRequerimiento() {
        return fechaDeRequerimiento;
    }

    public void setFechaDeRequerimiento(Date fechaDeRequerimiento) {
        this.fechaDeRequerimiento = fechaDeRequerimiento;
    }

    public Date getFechaDeSegundoRequerimiento() {
        return fechaDeSegundoRequerimiento;
    }

    public void setFechaDeSegundoRequerimiento(Date fechaDeSegundoRequerimiento) {
        this.fechaDeSegundoRequerimiento = fechaDeSegundoRequerimiento;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public Requerimiento Notificacion() {
        return this;
    }

    public void DeterminarPrioridad() {
        // Comparar la cantidad de días desde la fecha de creacion del requerimiento
        if (obtenerDiferenciaDias(this.fechaDeRecepcion) > 29) {
            this.prioridad = Prioridad.ALTA;
        } else {
            this.prioridad = Prioridad.BAJA;
        }
    }

    public static int obtenerDiferenciaDias(Date fecha) {
        // Obtiene la fecha actual
        Date fechaActual = new Date();

        // Crea los objetos de calendario para las fechas
        Calendar calFecha = Calendar.getInstance();
        calFecha.setTime(fecha);

        Calendar calFechaActual = Calendar.getInstance();
        calFechaActual.setTime(fechaActual);

        // Descarta las horas, minutos, segundos y milisegundos de los calendarios
        calFecha.set(Calendar.HOUR_OF_DAY, 0);
        calFecha.set(Calendar.MINUTE, 0);
        calFecha.set(Calendar.SECOND, 0);
        calFecha.set(Calendar.MILLISECOND, 0);

        calFechaActual.set(Calendar.HOUR_OF_DAY, 0);
        calFechaActual.set(Calendar.MINUTE, 0);
        calFechaActual.set(Calendar.SECOND, 0);
        calFechaActual.set(Calendar.MILLISECOND, 0);

        // Calcula la diferencia en milisegundos
        long diferenciaMilisegundos = calFechaActual.getTimeInMillis() - calFecha.getTimeInMillis();

        // Calcula la diferencia en días sin contar sábados ni domingos
        int diferenciaDias = 0;
        int diasNoContados = 0;

        while (calFecha.before(calFechaActual)) {
            calFecha.add(Calendar.DAY_OF_MONTH, 1);

            if (calFecha.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY &&
                    calFecha.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                diferenciaDias++;
            } else {
                diasNoContados++;
            }
        }

        // Resta los días no contados si hay más de 5 días de diferencia
        if (diasNoContados > 5) {
            diferenciaDias -= (diasNoContados - 5);
        }

        return diferenciaDias;
    }
}
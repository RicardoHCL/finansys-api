package com.finasys.api.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 */
public class FinUtil {

	/**
	 * Locale Brasileiro
	 */
	private static final Locale BRAZIL = new Locale("pt", "BR");

	/**
	 * Simbolos especificos do Real Brasileiro
	 */
	private static final DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);

	/**
	 * Mascara de dinheiro para Real Brasileiro
	 */
	public static final DecimalFormat MOEDA_REAL = new DecimalFormat("###,###,##0.00", REAL);

	/**
	 * Mascara texto com formatacao monetaria
	 *
	 * @param valor em BigDecimal
	 * @return Valor em string
	 */
	public static String colocarMascaraReal(BigDecimal valor) {
		return MOEDA_REAL.format(valor);
	}
	/**
	 * Converte uma data em string
	 *
	 * @param data em LocalDate
	 * @return String da data informada
	 */
	public static String converteDataParaString(LocalDate data) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String stringFormatada = data.format(formato);
		return stringFormatada;
	}

	/**
	 * Converte um valor decimal em String para BigDecimal
	 *
	 * @param valor em String
	 * @return valor em BigDecimal
	 */
	public static BigDecimal converterStringParaBigDecimal(String valor) {
		String valorFormatado = retirarFormatacaoNumeroDecimal(valor);
		return new BigDecimal(valorFormatado);
	}

	/**
	 * Converte uma data em String para LocalDate
	 *
	 * @param data em string
	 * @return data em LocalDate
	 */
	public static LocalDate converterStringParaLocalDate(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(data, formatter);
		return localDate;
	}

	/**
	 * Converte data no padrão DD-MM-AAAA para DD/MM/AAAA
	 *
	 * @param data
	 * @return data formatada
	 */
	public static String convertToDataPadrao(String data) {
		return data.replaceAll("-", "/");
	}

	/**
	 * Retorna a data atual
	 *
	 * @return Data Atual
	 */
	public static LocalDateTime getDataAtual() {
		return LocalDateTime.now();
	}

	/**
	 * Verifica se uma string é nula ou está em branco
	 *
	 * @param string
	 * @return true se a string for nula ou em branco, false do contrário.
	 */
	public static boolean isNullOrEmpty(String string) {
		return string == null || string.trim().isEmpty();
	}

	/**
	 * validar se o valor passado é maior ou igual a zero
	 *
	 * @param valor
	 * @return true se o valor passado não for nulo e for maior ou igual a 0.
	 */
	public static boolean isValorInteiroValido(Integer valor) {
		return valor != null && valor >= 0;
	}

	/**
	 * Converte a string passada para um valor decimal que utiliza o ponto (.) como
	 * separador.
	 *
	 * @param valor String que deseja-se converter
	 * @return String de valor convertida
	 */
	public static String retirarFormatacaoNumeroDecimal(String valor) {
		String retorno = null;
		if ((valor != null) && !valor.isEmpty()) {
			retorno = valor.replaceAll("\\.", "").replaceAll(",", ".");
		}
		return retorno;
	}

}

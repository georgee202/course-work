package com.kursovaya_fixed.view;

import java.math.BigInteger;

public interface TransactionsView {
    BigInteger getCustomerID();
    String getDateTime();
    String getDescription();
    BigInteger getMccCode();
    Double getAmount();
    String getTerminal();
}

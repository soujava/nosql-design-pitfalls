package jakarta.nosql.demo.document;

import jakarta.nosql.mapping.AttributeConverter;
import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;

public class MoneyConverter implements AttributeConverter<MonetaryAmount, String> {

    @Override
    public String convertToDatabaseColumn(MonetaryAmount attribute) {
        if (attribute != null) {
            return attribute.toString();
        }
        return null;
    }

    @Override
    public MonetaryAmount convertToEntityAttribute(String dbData) {
        if (dbData != null) {
            return Money.parse(dbData);
        }
        return null;
    }
}

package playground.enum_persisting;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private Category category;

    public static enum Category {
        SPORT("S"), MUSIC("M"), TECHNOLOGY("T");

        @Getter
        private String category;

        private Category(String category) {
            this.category = category;
        }

        public static Category of(String category) {
            return Stream.of(Category.values())
                    .filter(value -> value.getCategory().equals(category))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }

    }

    @Converter(autoApply = true)
    public static class CategoryConverter implements AttributeConverter<Category, String> {
        @Override
        public String convertToDatabaseColumn(Category category) {
            if (category == null) {
                return null;
            }
            return category.getCategory();
        }

        @Override
        public Category convertToEntityAttribute(String category) {
            if (category == null) {
                return null;
            }

            return Category.of(category);
        }
    }
}

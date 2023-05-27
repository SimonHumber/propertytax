public class PropertyTax {

  private final double ASSESSMENT_MODIFIER = 0.6;
  private final double RESIDENTIAL_RATE = 0.821;
  private final double COMMERCIAL_RATE = 1.78;
  private final double FARM_RATE = 0.152;
  private final double MUNICIPAL_SHARE = 0.471;
  private final double REGIONAL_SHARE = 0.332;
  private final double EDUCATION_SHARE = 1 - MUNICIPAL_SHARE - REGIONAL_SHARE;
  private final String RESIDENTIAL = "residential";
  private final String COMMERCIAL = "commercial";
  private final String FARM = "farm";
  private double propertyValue;
  private String propertyType;

  public PropertyTax() {}

  public PropertyTax(char propertyInput, double valueInput) {

    switch (Character.toLowerCase(propertyInput)) {
      case 'r':
        propertyType = RESIDENTIAL;
        break;
      case 'c':
        propertyType = COMMERCIAL;
        break;
      case 'f':
        propertyType = FARM;
        break;
    }
    propertyValue = valueInput;
  }

  public String getPropertyType() {
    return propertyType;
  }

  public void setPropertyType(char newProperty) {
    switch (Character.toLowerCase(newProperty)) {
      case 'r':
        propertyType = RESIDENTIAL;
        break;
      case 'c':
        propertyType = COMMERCIAL;
        break;
      case 'f':
        propertyType = FARM;
        break;
    }
  }

  public double getPropertyValue() {
    return propertyValue;
  }

  public void setPropertyValue(double newValue) {
    propertyValue = newValue;
  }

  public double getAssessedValue() {
    return propertyValue * ASSESSMENT_MODIFIER;
  }

  public double getPropertyTax() {
    switch (propertyType) {
      case RESIDENTIAL:
        return getAssessedValue() / 100 * RESIDENTIAL_RATE;
      case COMMERCIAL:
        return getAssessedValue() / 100 * COMMERCIAL_RATE;
      default:
        return getAssessedValue() / 100 * FARM_RATE;
    }
  }

  public double getMunicipalShare() {
    return getPropertyTax() * MUNICIPAL_SHARE;
  }

  public double getRegionalShare() {
    return getPropertyTax() * REGIONAL_SHARE;
  }

  public double getEducationShare() {
    return getPropertyTax() * EDUCATION_SHARE;
  }

  public String toString() {
    return "You own a "
        + propertyType
        + " property whose market value is $"
        + String.format("%.2f", propertyValue)
        + ".\nYour property is assessed at a value of $"
        + String.format("%.2f", getAssessedValue())
        + " and your property taxes are $"
        + String.format("%.2f", getPropertyTax())
        + ".\nYou pay: \n$"
        + String.format("%.2f", getMunicipalShare())
        + " in municipal taxes ("
        + String.format("%.1f", MUNICIPAL_SHARE * 100)
        + "% of the total property tax)\n$"
        + String.format("%.2f", getRegionalShare())
        + " in regional taxes ("
        + String.format("%.1f", REGIONAL_SHARE * 100)
        + "% of the total property tax)\n$"
        + String.format("%.2f", getEducationShare())
        + " in education taxes ("
        + String.format("%.1f", EDUCATION_SHARE * 100)
        + "% of the total property tax)";
  }
}

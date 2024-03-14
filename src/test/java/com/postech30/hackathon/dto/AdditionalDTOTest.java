package com.postech30.hackathon.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AdditionalDTO.class})
@ExtendWith(SpringExtension.class)
class AdditionalDTOTest {
  @Autowired
  private AdditionalDTO additionalDTO;

  /**
   * Method under test: {@link AdditionalDTO#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    assertFalse(additionalDTO.canEqual("Other"));
    assertTrue(additionalDTO.canEqual(additionalDTO));
  }

  /**
   * Method under test: {@link AdditionalDTO#equals(Object)}
   */
  @Test
  void testEquals() {
    assertNotEquals(new AdditionalDTO(), null);
    assertNotEquals(new AdditionalDTO(), "Different type to AdditionalDTO");
  }

  /**
   * Method under test: {@link AdditionalDTO#equals(Object)}
   */
  @Test
  void testEquals2() {
    AdditionalDTO additionalDTO = new AdditionalDTO(1L, "Name", "The characteristics of someone or something", 10.0d,
            "Type");
    assertNotEquals(additionalDTO, new AdditionalDTO());
  }

  /**
   * Method under test: {@link AdditionalDTO#equals(Object)}
   */
  @Test
  void testEquals3() {
    AdditionalDTO additionalDTO = new AdditionalDTO();
    assertNotEquals(additionalDTO,
            new AdditionalDTO(1L, "Name", "The characteristics of someone or something", 10.0d, "Type"));
  }

  /**
   * Method under test: {@link AdditionalDTO#equals(Object)}
   */
  @Test
  void testEquals4() {
    AdditionalDTO additionalDTO = new AdditionalDTO();
    additionalDTO.setName("Name");
    assertNotEquals(additionalDTO, new AdditionalDTO());
  }

  /**
   * Method under test: {@link AdditionalDTO#equals(Object)}
   */
  @Test
  void testEquals5() {
    AdditionalDTO additionalDTO = new AdditionalDTO();
    additionalDTO.setDescription("The characteristics of someone or something");
    assertNotEquals(additionalDTO, new AdditionalDTO());
  }

  /**
   * Method under test: {@link AdditionalDTO#equals(Object)}
   */
  @Test
  void testEquals6() {
    AdditionalDTO additionalDTO = new AdditionalDTO();
    additionalDTO.setPrice(10.0d);
    assertNotEquals(additionalDTO, new AdditionalDTO());
  }

  /**
   * Method under test: {@link AdditionalDTO#equals(Object)}
   */
  @Test
  void testEquals7() {
    AdditionalDTO additionalDTO = new AdditionalDTO();
    additionalDTO.setType("Type");
    assertNotEquals(additionalDTO, new AdditionalDTO());
  }

  /**
   * Method under test: {@link AdditionalDTO#equals(Object)}
   */
  @Test
  void testEquals8() {
    AdditionalDTO additionalDTO = new AdditionalDTO();

    AdditionalDTO additionalDTO2 = new AdditionalDTO();
    additionalDTO2.setName("Name");
    assertNotEquals(additionalDTO, additionalDTO2);
  }

  /**
   * Method under test: {@link AdditionalDTO#equals(Object)}
   */
  @Test
  void testEquals9() {
    AdditionalDTO additionalDTO = new AdditionalDTO();

    AdditionalDTO additionalDTO2 = new AdditionalDTO();
    additionalDTO2.setDescription("The characteristics of someone or something");
    assertNotEquals(additionalDTO, additionalDTO2);
  }

  /**
   * Method under test: {@link AdditionalDTO#equals(Object)}
   */
  @Test
  void testEquals10() {
    AdditionalDTO additionalDTO = new AdditionalDTO();

    AdditionalDTO additionalDTO2 = new AdditionalDTO();
    additionalDTO2.setPrice(10.0d);
    assertNotEquals(additionalDTO, additionalDTO2);
  }

  /**
   * Method under test: {@link AdditionalDTO#equals(Object)}
   */
  @Test
  void testEquals11() {
    AdditionalDTO additionalDTO = new AdditionalDTO();

    AdditionalDTO additionalDTO2 = new AdditionalDTO();
    additionalDTO2.setType("Type");
    assertNotEquals(additionalDTO, additionalDTO2);
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link AdditionalDTO#equals(Object)}
   *   <li>{@link AdditionalDTO#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode() {
    AdditionalDTO additionalDTO = new AdditionalDTO();
    assertEquals(additionalDTO, additionalDTO);
    int expectedHashCodeResult = additionalDTO.hashCode();
    assertEquals(expectedHashCodeResult, additionalDTO.hashCode());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link AdditionalDTO#equals(Object)}
   *   <li>{@link AdditionalDTO#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode2() {
    AdditionalDTO additionalDTO = new AdditionalDTO();
    AdditionalDTO additionalDTO2 = new AdditionalDTO();
    assertEquals(additionalDTO, additionalDTO2);
    int expectedHashCodeResult = additionalDTO.hashCode();
    assertEquals(expectedHashCodeResult, additionalDTO2.hashCode());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link AdditionalDTO#equals(Object)}
   *   <li>{@link AdditionalDTO#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode3() {
    AdditionalDTO additionalDTO = new AdditionalDTO(1L, "Name", "The characteristics of someone or something", 10.0d,
            "Type");
    AdditionalDTO additionalDTO2 = new AdditionalDTO(1L, "Name", "The characteristics of someone or something", 10.0d,
            "Type");

    assertEquals(additionalDTO, additionalDTO2);
    int expectedHashCodeResult = additionalDTO.hashCode();
    assertEquals(expectedHashCodeResult, additionalDTO2.hashCode());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link AdditionalDTO#AdditionalDTO()}
   *   <li>{@link AdditionalDTO#setDescription(String)}
   *   <li>{@link AdditionalDTO#setId(Long)}
   *   <li>{@link AdditionalDTO#setName(String)}
   *   <li>{@link AdditionalDTO#setPrice(Double)}
   *   <li>{@link AdditionalDTO#setType(String)}
   *   <li>{@link AdditionalDTO#toString()}
   *   <li>{@link AdditionalDTO#getDescription()}
   *   <li>{@link AdditionalDTO#getId()}
   *   <li>{@link AdditionalDTO#getName()}
   *   <li>{@link AdditionalDTO#getPrice()}
   *   <li>{@link AdditionalDTO#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    AdditionalDTO actualAdditionalDTO = new AdditionalDTO();
    actualAdditionalDTO.setDescription("The characteristics of someone or something");
    actualAdditionalDTO.setId(1L);
    actualAdditionalDTO.setName("Name");
    actualAdditionalDTO.setPrice(10.0d);
    actualAdditionalDTO.setType("Type");
    String actualToStringResult = actualAdditionalDTO.toString();
    String actualDescription = actualAdditionalDTO.getDescription();
    Long actualId = actualAdditionalDTO.getId();
    String actualName = actualAdditionalDTO.getName();
    Double actualPrice = actualAdditionalDTO.getPrice();
    assertEquals("AdditionalDTO(id=1, name=Name, description=The characteristics of someone or something, price=10.0,"
            + " type=Type)", actualToStringResult);
    assertEquals("Name", actualName);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals("Type", actualAdditionalDTO.getType());
    assertEquals(10.0d, actualPrice.doubleValue());
    assertEquals(1L, actualId.longValue());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link AdditionalDTO#AdditionalDTO(Long, String, String, Double, String)}
   *   <li>{@link AdditionalDTO#setDescription(String)}
   *   <li>{@link AdditionalDTO#setId(Long)}
   *   <li>{@link AdditionalDTO#setName(String)}
   *   <li>{@link AdditionalDTO#setPrice(Double)}
   *   <li>{@link AdditionalDTO#setType(String)}
   *   <li>{@link AdditionalDTO#toString()}
   *   <li>{@link AdditionalDTO#getDescription()}
   *   <li>{@link AdditionalDTO#getId()}
   *   <li>{@link AdditionalDTO#getName()}
   *   <li>{@link AdditionalDTO#getPrice()}
   *   <li>{@link AdditionalDTO#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    AdditionalDTO actualAdditionalDTO = new AdditionalDTO(1L, "Name", "The characteristics of someone or something",
            10.0d, "Type");
    actualAdditionalDTO.setDescription("The characteristics of someone or something");
    actualAdditionalDTO.setId(1L);
    actualAdditionalDTO.setName("Name");
    actualAdditionalDTO.setPrice(10.0d);
    actualAdditionalDTO.setType("Type");
    String actualToStringResult = actualAdditionalDTO.toString();
    String actualDescription = actualAdditionalDTO.getDescription();
    Long actualId = actualAdditionalDTO.getId();
    String actualName = actualAdditionalDTO.getName();
    Double actualPrice = actualAdditionalDTO.getPrice();
    assertEquals("AdditionalDTO(id=1, name=Name, description=The characteristics of someone or something, price=10.0,"
            + " type=Type)", actualToStringResult);
    assertEquals("Name", actualName);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals("Type", actualAdditionalDTO.getType());
    assertEquals(10.0d, actualPrice.doubleValue());
    assertEquals(1L, actualId.longValue());
  }
}

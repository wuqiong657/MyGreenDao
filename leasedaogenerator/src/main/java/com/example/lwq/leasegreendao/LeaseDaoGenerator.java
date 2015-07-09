package com.example.lwq.leasegreendao;


import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class LeaseDaoGenerator {
  public static void main(String[] args) throws Exception{
      Schema schema = new Schema(1, "com.lwq.generator");

      Entity person = schema.addEntity("Person");
      person.addIdProperty();
      person.addStringProperty("name");
      person.addIntProperty("age");
      person.addBooleanProperty("isGraduated");

      Entity lease = schema.addEntity("Lease");
      lease.addIdProperty();
      lease.addStringProperty("bookName");
      lease.addDateProperty("leaseDate");
      lease.addDateProperty("returnDate");
      Property personId = lease.addLongProperty("personId").getProperty();

      person.addToMany(lease, personId);
      lease.addToOne(person, personId);

      new DaoGenerator().generateAll(schema, "app/src/main/java");
  }
}

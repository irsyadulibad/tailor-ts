package polije.ppl.tailor.repository;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import polije.ppl.tailor.entity.Entity;
import polije.ppl.tailor.util.DatabaseUtil;

public interface Repository<E extends Entity> {
    final Connection conn = DatabaseUtil.getConnection();

    /**
     * Get all records
     * @return
     */
    public List<E> get();

    /**
     * Get all records with specific criterias
     * @param values
     * @return
     */
    public List<E> get(Map<String, Object> values);

    /**
     * Insert record to database
     * @param entity
     * @return
     */
    public boolean add(E entity);

    /**
     * Update the record
     * @param entity
     * @param data
     * @return
     */
    public boolean update(E entity, E data);

    /**
     * Delete the specific record
     * @param id
     * @return
     */
    public boolean delete(int id);
}

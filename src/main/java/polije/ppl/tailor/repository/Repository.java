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
     * Return record by id
     * @param id
     * @return
     */
    public E get(Integer id);

    /**
     * Get all records with specific criterias
     * @param values
     * @return
     */
    public List<E> get(Map<String, Object> values);

    /**
     * Get all records with like query
     * @param values
     * @return
     */
    public List<E> search(Map<String, Object> values);

    /**
     * Insert record to database
     * @param entity
     * @return
     */
    public Integer add(E entity);

    /**
     * Update the record
     * @param entity
     * @param data
     * @return
     */
    public boolean update(E entity);

    /**
     * Delete the specific record
     * @param id
     * @return
     */
    public boolean delete(int id);
}

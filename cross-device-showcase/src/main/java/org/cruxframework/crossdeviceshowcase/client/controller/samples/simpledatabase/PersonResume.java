/**
 * 
 */
package org.cruxframework.crossdeviceshowcase.client.controller.samples.simpledatabase;

/**
 * @author Thiago da Rosa de Bustamante
 *
 */
public class PersonResume 
{
	private Integer id;
	private String name;
	
	public PersonResume()
	{
		
	}
	
	public PersonResume(Integer id, String name) 
	{
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() 
	{
		return id;
	}
	public String getName() 
	{
		return name;
	}
}

package com.jcseg.tokenizer;


import com.jcseg.tokenizer.core.IWord;
import com.jcseg.tokenizer.core.SynonymsEntry;
import com.jcseg.util.ArrayUtil;

import java.util.List;


/**
 * word class for Jcseg with the {@link org.lionsoul.jcseg.core.IWord} interface implemented
 * 
 * at 2017/03/29: 
 * make the synonyms series method {@link #getSyn()} {@link #setSyn(SynonymsEntry)} 
 * and the part of speech series method {@link #getPartSpeech()} {@link #setPartSpeech(String[])} {@link #addPartSpeech(String)}
 * and the {@link #clone()} method synchronized for may coming concurrent access.
 * 
 * @author  chenxin<chenxin619315@gmail.com>
 */
public class Word implements IWord,Cloneable
{
    private String value;
    private int fre = 0;
    private int type;
    private int position;
    
    /**
     * well the we could get the length of the word by invoke #getValue().length
     * owing to the implementation of Jcseg and {@link #getValue()}.length may no equals to {@link #getLength()}
     * 
     * {@link #getLength()} will return the value setted by
     */
    private int length = -1;
    private int h = -1;
    
    /**
     * @Note added at 2016/11/12
     * word string entity name and 
     * it could be assign from the lexicon or the word item setting
     * or assign dynamic during the segment runtime
     * 
     * @Note make it an Array at 2017/06/06
    */
    private String[] entity = null;
    
    private String pinyin = null;
    private String[] partspeech = null;
    private volatile SynonymsEntry syn = null;
    
    /**
     * construct method to initialize the newly created Word instance
     * 
     * @param   value
     * @param   fre
     * @param   type
     * @param   entity
    */
    public Word(String value, int fre, int type, String[] entity)
    {
        this.value  = value;
        this.fre    = fre;
        this.type   = type;
        this.entity = entity;
    }

    public Word( String value, int fre, int type ) 
    {
        this(value, fre, type, null);
    }
    
    public Word( String value, int type ) 
    {
        this(value, 0, type, null);
    }
    
    public Word(String value, int type, String entity[])
    {
        this(value, 0, type, entity);
    }
    
    /**
     * @see IWord#getValue() 
     */
    @Override
    public String getValue() 
    {
        return value;
    }
    
    /**
     * @see IWord#getLength() 
     */
    @Override
    public int getLength() 
    {
        return (length == -1 ) ? value.length() : length;
    }
    

    /**
     * @see IWord#setLength(int) 
     */
    @Override
    public void setLength( int length ) 
    {
        this.length = length;
    }

    /**
     * @see IWord#getFrequency() 
     */
    @Override
    public int getFrequency() 
    {
        return fre;
    }

    /**
     * @see IWord#getType() 
     */
    @Override
    public int getType() 
    {
        return type;
    }
    
    /**
     * @see IWord#setPosition(int)
     */
    @Override
    public void setPosition( int pos ) 
    {
        position = pos;
    }
    
    /**
     * @see IWord#getPosition()
     */
    public int getPosition()
    {
        return position;
    }
    
    /**
     * @see IWord#getEntity()
    */
    public synchronized String[] getEntity() 
    {
        return entity;
    }
    
    /**
     * @see IWord#getEntity(int)
    */
    public synchronized String getEntity(int idx) 
    {
        if ( entity == null ) {
            return null;
        }
        
        if ( idx < 0 || idx > entity.length ) {
            return null;
        }
        
        return entity[idx];
    }
    
    /**
     * @see IWord#setEntity(String)
    */
    public synchronized void setEntity(String[] entity) 
    {
        this.entity = entity;
    }
    
    /**
     * @see IWord#addEntity(String) 
    */
    public synchronized void addEntity(String e)
    {
        if ( e == null ) {
            
        } else if ( entity == null ) {
            entity = new String[]{e};
        } else if ( ArrayUtil.indexOf(e, entity) == -1 ) {
            String[] dest = new String[entity.length+1];
            System.arraycopy(entity, 0, dest, 0, entity.length);
            dest[entity.length] = e;
            entity = dest;
        }
    }
    
    /**
     * @see IWord#getPinying() 
     */
    @Override
    public String getPinyin() 
    {
        return pinyin;
    }
    
    /**
     * @see IWord#setPinying(String)
     */
    public void setPinyin( String py ) 
    {
        pinyin = py;
    }

    /**
     * @see IWord#getSyn() 
     */
    @Override
    public SynonymsEntry getSyn() 
    {
        return syn;
    }

    @Override
    public void setSyn(SynonymsEntry syn) 
    {
        this.syn = syn;
    }
    
    /**
     * @see IWord#getPartSpeech() 
     */
    @Override
    public synchronized String[] getPartSpeech() 
    {
        return partspeech;
    }
    
    @Override
    public synchronized void setPartSpeech(String[] partspeech) 
    {
        this.partspeech = partspeech;
    }
    
    /**
     * @see IWord#addPartSpeech( String );
     */
    @Override
    public synchronized void addPartSpeech( String ps ) 
    {
        if ( partspeech == null ) {
            partspeech = new String[]{ps};
        } else {            
            String[] dest = new String[partspeech.length+1];
            System.arraycopy(partspeech, 0, dest, 0, partspeech.length);
            dest[partspeech.length] = ps;
            partspeech = dest;
        }
    }
    
    /**
     * Interface to clone the current object
     * 
     * @return IWord
     */
    @Override
    public synchronized IWord clone()
    {
        IWord w = null;
        try {
            w = (IWord) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        
        return w;
    }
    
    
    /**
     * @see Object#equals(Object) 
     * @see IWord#equals(Object)
     */
    public boolean equals( Object o ) 
    {
        if ( this == o ) return true;
        
        if ( o instanceof IWord ) {
            IWord word = (IWord) o;
            boolean bool = word.getValue().equalsIgnoreCase(this.getValue());
            /*
             * value equals and the type of the word must
             * be equals too, for there is many words in
             * different lexicon with a same value but 
             * in different use. 
             */
            return (bool && (word.getType() == this.getType()));
        }
        
        return false;
    }
    
    /**
     * for debug only 
    */
    public String __toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        sb.append('/');
        //append the cx
        if ( partspeech != null ) {
            for ( int j = 0; j < partspeech.length; j++ ) {
                if ( j == 0 ) {
                    sb.append(partspeech[j]);
                } else {
                    sb.append(',');
                    sb.append(partspeech[j]);
                }
            }
        } else {
            sb.append("null");
        }
        
        sb.append('/');
        sb.append(pinyin);
        sb.append('/');
        
        if ( syn != null ) {
            List<IWord> synsList = syn.getList();
            synchronized ( synsList ) {
                for ( int i = 0; i < synsList.size(); i++ ) {
                    if ( i == 0 ) {
                        sb.append(synsList.get(i));
                    } else {
                        sb.append(',');
                        sb.append(synsList.get(i));
                    }
                }
            }
        } else {
            sb.append("null");
        }
        
        if ( value.length() == 1 ) {
            sb.append('/');
            sb.append(fre);
        }
        
        if ( entity != null ) {
            sb.append('/');
            sb.append(ArrayUtil.implode("|", entity));
        }
        
        return sb.toString();
    }
    
    /**
     * @see Object#toString()
     */
    public String toString() 
    {
            
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        
        /*
         * @Note: Check and pre-process the word value
         * for if there is char "\"" or "\\" inside 
         * the Json Anti-analysis will be end with parse error ...
         */
        if ( value.length() == 1 
                && (value.charAt(0) == '"' || value.charAt(0) == '\\') ) {
            sb.append("\"word\":\"\\").append(value).append('"');
        } else {
            sb.append("\"word\":\"").append(value).append('"');
        }
        
        sb.append(",\"position\":").append(position);
        sb.append(",\"length\":").append(getLength());
        
        if ( pinyin != null ) {
            sb.append(",\"pinyin\":\"").append(pinyin).append('"');
        } else {
            sb.append(",\"pinyin\":null");
        }
        
        if ( partspeech != null ) {
            sb.append(",\"pos\":\"").append(partspeech[0]).append('"');
        } else {
            sb.append(",\"pos\":null");
        }
        
        if ( entity != null ) {
            sb.append(",\"entity\":")
                .append(ArrayUtil.toJsonObject(entity));
        } else {
            sb.append(",\"entity\":null");
        }
        
        //check and append the base word of the synonyms
        SynonymsEntry synEntry = getSyn();
        if ( synEntry != null ) {
            IWord rootWord = synEntry.getRootWord();
            sb.append(",\"root\":{")
                .append("\"word\":\"").append(rootWord.getValue())
                .append("\",\"length\":").append(rootWord.getLength())
                    .append(",\"pinyin\":");
            if ( rootWord.getPinyin() == null ) {
                sb.append("null");
            } else {
                sb.append('"').append(rootWord.getPinyin()).append('"');
            }
            
            sb.append('}');
        } else {
            sb.append(",\"root\":null");
        }
        
        sb.append('}');
        return sb.toString();
    }
    
    /**
     * rewrite the hash code generate algorithm
     * take the value as the main factor
     *  
     * @return  int
    */
    @Override
    public int hashCode()
    {
        if ( h == -1 ) {
            /*
             * DJB hash algorithm 2
             * invented by doctor Daniel J. Bernstein.
             */
            h = 5381;
            for ( int j = 0; j < value.length(); j++ ) {
                h = h * 33 ^ value.charAt(j);
            }
            h &= 0x7FFFFFFF;
        }
        
        return h;
    }
    
}

package solution;
import util.DoubleNode;
/**
 * A DoubleLinkedSeq is a sequence of double numbers. The sequence can have a
 * special &quot;current element&quot;, which is specified and accessed through
 * four methods that are not available in the IntArrayBag class (start,
 * getCurrent, advance, and isCurrent).
 * 
 * Limitations:
 * 
 * Beyond Integer.MAX_VALUE element, the size method does not work.
 * 
 * @author Aaron Mosteller
 * @version 3/13/2019
 */

public class DoubleLinkedSeq implements Cloneable
{
    private int manyNodes;
    private DoubleNode head;
    private DoubleNode tail;
    private DoubleNode cursor;
    private DoubleNode precursor;
    /**
     * Initializes an empty DoubleLinkedSeq.
     * 
     * @postcondition This sequence is empty.
     */
    public DoubleLinkedSeq()
    {
        // code for constructor
        head = null;
        tail = null;
        cursor = null;
        precursor = null;
        manyNodes = 0;

    }
    /**
     * Adds a new element to this sequence.
     * 
     * @param element
     *            the new element that is being added to this sequence.
     * 
     * @postcondition a new copy of the element has been added to this sequence.
     *                If there was a current element, then this method places
     *                the new element before the current element. If there was
     *                no current element, then this method places the new
     *                element at the front of this sequence. The newly added
     *                element becomes the new current element of this sequence.
     */
    public void addBefore(double element)
    {
        // code for addBefore
        if (head == null && tail == null)
        {
            head = new DoubleNode(element);
            tail = head;
            cursor = head;
        }
        else if (cursor == null)
        {
            head = new DoubleNode(element, head);
            cursor = head;
        }
        else if (precursor == null)
        {
            head = new DoubleNode(element, head);
            cursor = head;
        }
        else if (cursor != null && precursor != null)
        {
            DoubleNode newElement = new DoubleNode(element, cursor);
            precursor.setLink(newElement);
            cursor = newElement;
            
        }
        manyNodes++;
    }
    /**
     * Adds a new element to this sequence.
     * 
     * @param element
     *            the new element that is being added to this sequence.
     * 
     * @postcondition a new copy of the element has been added to this sequence.
     *                If there was a current element, then this method places
     *                the new element after the current element. If there was no
     *                current element, then this method places the new element
     *                at the end of this sequence. The newly added element
     *                becomes the new current element of this sequence.
     */
    public void addAfter(double element)
    {
        if (manyNodes == 0)
        {
            head = new DoubleNode(element);
            tail = head;
            cursor = head;
        }
        else if (manyNodes == 1)
        {
            DoubleNode newElement = new DoubleNode(element);
            head.setLink(newElement);
            tail = newElement;
            cursor = tail;
            precursor = head;
        }
        else if (cursor == head)
        {
            DoubleNode newElement = new DoubleNode(element, cursor.getLink());
            head.setLink(newElement);
            cursor = cursor.getLink();
            precursor = head;
        }
        else if (cursor != head && precursor != null)
        {
            DoubleNode newElement = new DoubleNode(element, cursor.getLink());
            cursor.setLink(newElement);
            if (cursor == tail)
            {
                tail = tail.getLink();
            }
            cursor = cursor.getLink();
            precursor = precursor.getLink();
        }
        else if (!isCurrent())
        {
            DoubleNode newElement = new DoubleNode(element);
            tail.setLink(newElement);
            precursor = tail;
            tail = tail.getLink();
            cursor = tail;
        }
        manyNodes++;
    }
    /**
     * Places the contents of another sequence at the end of this sequence.
     * 
     * @precondition other must not be null.
     * 
     * @param other
     *            a sequence show contents will be placed at the end of this
     *            sequence.
     * 
     * @postcondition the elements from other have been placed at the end of
     *                this sequence. The current element of this sequence
     *                remains where it was, and other is unchanged.
     * 
     * @throws NullPointerException
     *             if other is null.
     */
    public void addAll(DoubleLinkedSeq other) throws NullPointerException
    {
        if (other == null)
        {
            throw new NullPointerException("Second sequence cannot be null.");
        }
        else
        {
            DoubleLinkedSeq otherClone = other.clone();
            tail.setLink(otherClone.head);
            tail = otherClone.tail;
            manyNodes += otherClone.size();
        }
    }
    /**
     * Move forward so that the current element is now the next element in the
     * sequence.
     * 
     * @precondition isCurrent() returns true.
     * 
     * @postcondition If the current element was already the end element of this
     *                sequence (with nothing after it), then there is no longer
     *                any current element. Otherwise, the new element is the
     *                element immediately after the original current element.
     * 
     * @throws IllegalStateException
     *             if there is not current element.
     */
    public void advance() throws IllegalStateException
    {
        if (isCurrent())
        {
            if (cursor == tail)
            {
                cursor = null;
                precursor = null;
            }
            else if (cursor != tail && cursor != head)
            {
                cursor = cursor.getLink();
                precursor = precursor.getLink();
            }
            else if (cursor == head)
            {
                cursor = cursor.getLink();
                precursor = head;
            }
        } 
        else
        {
            throw new IllegalStateException("There is no current element.");
        }
    }
    /**
     * Creates a copy of this sequence.
     * 
     * @return a copy of this sequence. Subsequent changes to the copy will not
     *         affect the original, nor vice versa.
     * @throws RuntimeException
     *             if this class does not implement Cloneable.
     * 
     */
    public DoubleLinkedSeq clone() throws RuntimeException
    {
        DoubleLinkedSeq cloneSeq;
        try 
        {
            cloneSeq = (DoubleLinkedSeq) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException(
            "This class does not implement Cloneable.");
        }
        if (cursor == null)
        {
            DoubleNode[] newList = DoubleNode.listCopyWithTail(head);
            cloneSeq.head = newList[0];
            cloneSeq.tail = newList[1];
        }
        else if (cursor == head)
        {
            DoubleNode[] newList = DoubleNode.listCopyWithTail(head);
            cloneSeq.head = newList[0];
            cloneSeq.tail = newList[1];
            cloneSeq.precursor = null;
            cloneSeq.cursor = cloneSeq.head;
        }
        else if (cursor != null && precursor != null) 
        {
            DoubleNode[] firstPart = DoubleNode.listPart(head, precursor);
            cloneSeq.head = firstPart[0];
            cloneSeq.precursor = firstPart[1];
            DoubleNode[] secondPart = DoubleNode.listPart(cursor, tail);
            cloneSeq.cursor = secondPart[0];
            cloneSeq.tail = secondPart[1];
            cloneSeq.precursor.setLink(cloneSeq.cursor);
        }
        return cloneSeq;            
    }
    /**
     * Creates a new sequence that contains all the elements from s1 followed by
     * all of the elements from s2.
     * 
     * @precondition neither s1 nor s2 are null.
     * 
     * @param s1
     *            the first of two sequences.
     * @param s2
     *            the second of two sequences.
     * 
     * @return a new sequence that has the elements of s1 followed by the
     *         elements of s2 (with no current element).
     * 
     * @throws NullPointerException
     *             if s1 or s2 are null.
     */
    public static DoubleLinkedSeq concatenation(DoubleLinkedSeq s1,
            DoubleLinkedSeq s2) throws NullPointerException
    {
        if (s1.size() == 0 || s2.size() == 0) 
        {
            throw new NullPointerException("The sequences cannot be null.");
        } 
        else 
        {
            DoubleLinkedSeq newSeq = s1.clone();
            newSeq.addAll(s2);
            while (newSeq.isCurrent()) 
            {
                newSeq.advance();
            }
            return newSeq;
        }
    }         
    /**
     * Returns a copy of the current element in this sequence.
     * 
     * @precondition isCurrent() returns true.
     * 
     * @return the current element of this sequence.
     * 
     * @throws IllegalStateException
     *             if there is no current element.
     */
    public double getCurrent() throws IllegalStateException
    {
        if (isCurrent())
        {
            return cursor.getData();
        }
        else
        {
            throw new IllegalStateException("There is no current element.");
        }
    }
    /**
     * Determines whether this sequence has specified a current element.
     * 
     * @return true if there is a current element, or false otherwise.
     */
    public boolean isCurrent()
    {
        return cursor != null;
    }
    /**
     * Removes the current element from this sequence.
     * 
     * @precondition isCurrent() returns true.
     * 
     * @postcondition The current element has been removed from this sequence,
     *                and the following element (if there is one) is now the new
     *                current element. If there was no following element, then
     *                there is now no current element.
     * 
     * @throws IllegalStateException
     *             if there is no current element.
     */
    public void removeCurrent() throws IllegalStateException 
    {
        if (!isCurrent()) 
        {
            throw new IllegalStateException("There is no current element.");
        } 
        else 
        {
            if (head == tail) 
            {
                head = null;
                tail = null;
                cursor = null;
                manyNodes--;
            }
            else if (cursor == head && precursor == null) 
            {
                head = head.getLink();
                cursor = head;
                manyNodes--;
            }
            else if (cursor != tail && precursor != null) 
            {
                cursor = cursor.getLink();
                precursor.setLink(cursor);
                manyNodes--;
            }
            else if (cursor == tail && precursor != null) 
            {
                cursor = null;
                precursor.setLink(null);
                precursor = null;
                manyNodes--;
            }
        }
    }
    /**
     * Determines the number of elements in this sequence.
     * 
     * @return the number of elements in this sequence.
     */
    public int size() 
    {
        return manyNodes;
    }

    /**
     * Sets the current element at the front of this sequence.
     * 
     * @postcondition If this sequence is not empty, the front element of this
     *                sequence is now the current element; otherwise, there is
     *                no current element.
     */
    public void start()
    {
        if (head != null) 
        {
            cursor = head;
        } 
        else 
        {
            cursor = null;
        }
        precursor = null;
    }
    /**
     * Returns a String representation of this sequence. If the sequence is
     * empty, the method should return &quot;&lt;&gt;&quot;. If the sequence has
     * one item, say 1.1, and that item is not the current item, the method
     * should return &quot;&lt;1.1&gt;&quot;. If the sequence has more than one
     * item, they should be separated by commas, for example: &quot;&lt;1.1,
     * 2.2, 3.3&gt;&quot;. If there exists a current item, then that item should
     * be surrounded by square braces. For example, if the second item is the
     * current item, the method should return: &quot;&lt;1.1, [2.2],
     * 3.3&gt;&quot;.
     * 
     * @return a String representation of this sequence.
     */
    @Override
    public String toString()
    {
        String str = "";
        if (!isCurrent()) 
        {
            if (head == null) 
            {
                str += "<>";
            }
            else if (manyNodes == 1) 
            {
                str += "<" + head.getData() + ">";
            }
            else if (manyNodes > 1) 
            {
                str += "<";
                for (DoubleNode temp = head; 
                    temp != null; temp = temp.getLink()) 
                {
                    str += "" + temp.getData();
                    if (temp.getLink() != null) 
                    {
                        str += ", ";
                    }
                }
                str += ">";
            }
        } 
        else 
        {
            if (manyNodes == 1) 
            {
                str += "<[" + head.getData() + "]>";
            }
            else if (manyNodes > 1) 
            {
                str += "<";
                for (DoubleNode temp = head; 
                    temp != null; temp = temp.getLink()) 
                {
                    if (temp == cursor) 
                    {
                        str += "[" + temp.getData() + "]";
                    }   
                    else  
                    {
                        str += "" + temp.getData();
                    }
                    if(temp.getLink() != null) 
                    {
                        str += ", ";
                    }
                }
                str += ">";
            }
        }
        return str;

    }
    /**
     * Determines if this object is equal to the other object.
     * 
     * @param other
     *            The other object (possibly a DoubleLinkedSequence).
     * @return true if this object is equal to the other object, false
     *         otherwise. Two sequences are equal if they have the same number
     *         of elements, and each corresponding element is equal
     */
    public boolean equals(Object other)
    {
        boolean result = true;
        DoubleLinkedSeq otherSeq = (DoubleLinkedSeq) other;
        if (manyNodes == otherSeq.manyNodes) 
        {
            for (DoubleNode temp1 = head, temp2 = otherSeq.head;
                temp1 != null;
                temp1 = temp1.getLink(), temp2 = temp2.getLink()) 
            {
                if (temp1.getData() != temp2.getData()) 
                {
                    result = false;
                    break;
                }
                if (temp1 == cursor && temp2 != otherSeq.cursor) 
                {
                    result = false;
                    break;
                }
                if (temp2 == otherSeq.cursor && temp1 != cursor) 
                {
                    result = false;
                    break;
                }
            }
        }
        else 
        {
            result = false;
        }
        return result;
    }
}


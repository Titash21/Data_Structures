class Node(object):
    #This function initializes a node in the linkedList
    def __init__(self, data):
        self.data=data
        self.next=None

class LinkedList:
    def __init__(self):
        self.head=None
    #This method returns the head of theb linkedlist
    def get_head(self):
        if(self.head==None):
            return None
        else:
            return self.head


    def insertFront(self,data):
        new_node=Node(data)
        if(self.head==None):
            self.head=new_node
        else:
            new_node.next=self.head
            self.head=new_node

    def insertLast(self,data):
        new_node = Node(data)
        if(self.head== None ):
            self.head=new_node
        else:
            temp=self.head
            while(temp.next != None):
                temp=temp.next
            temp.next=new_node

    def display(self,head):
        # print("List is: ")
        if(head==None):
            print("empty list")
        else:
            temp=head
            while(temp!=None):
                print(temp.data)
                temp=temp.next

    # merge sort the linked list, recursively
    def sortList(self, head):

        # print("HEAD IS:", head.data)
        if not head or not head.next:
            return head
        # divide list into two parts
        fast, slow = head.next, head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        second = slow.next
        # cut down the first part
        slow.next = None

        l = self.sortList(head)
        r = self.sortList(second)
        # print("Left: ", l.data, "Right data", r.data)
        head_new=self.merge(l,r)
        # print("Head_new after merge: ",head_new.data)
        # self.display(head_new)
        return head_new

    # merge in-place without dummy node
    def merge(self, l, r):
        if not l or not r:
            return l or r
        if l.data > r.data:
            l, r = r, l
        # get the return node "head"
        head = pre = l
        l = l.next
        while l and r:
            if l.data < r.data:
                pre.next = l
                l = l.next
            else:
                nxt = pre.next
                pre.next = r
                tmp = r.next
                r.next = nxt
                r = tmp
            pre = pre.next
        # l and r at least one is None
        pre.next = l or r
        return head

    #Reverse the linked list
    def reverse(self,head):
        prev = None
        current = head
        while (current is not None):
            next = current.next
            current.next = prev
            prev = current
            current = next
        head = prev
        return (head)

    #Rotating a linkedlist
    def rotateAlist(self,head,k):
        print("Inside rotateAlist ")

        if (not head or k == 0):
            return head
        elif (not head.next):
            return head
        else:
            # Calculate the length of the list
            length = 0
            temp = head
            while (temp != None):
                length += 1
                temp = temp.next

            if ((k%length)==0  ):
                # reverse the list
                return head

            else:
                    check = length - (k % length)

                    print("Check is",check)
                    temp = head
                    prev=None
                    for i in range(check - 1):
                        prev=None
                        temp = temp.next

                    secondHalf=temp.next
                    temp
                    while (secondHalf.next != None):
                        rotation = rotation.next
                    rotation.next = head
                    return head

    #Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
    def detectCycle(self, head):
        slow = fast = head
        while (fast and fast.next):
            slow = slow.next
            fast = fast.next.next
            if (slow == fast):
                break

        if (fast == None):
            return None
        elif (fast.next == None):
            return None

        while (head != slow):
            slow = slow.next
            head = head.next
        return slow






def main():

    node = LinkedList()
    node.insertFront(2)
    node.insertFront(8)
    node.insertFront(3)
    node.insertFront(6)
    node.insertFront(1)
    node.insertFront(9)
    head=node.get_head()
    print("Original List is")
    node.display(head)

    head_new = node.sortList(head)
    print("Sorted List is")

    node.display(head_new)
    node2=LinkedList()
    node2.insertFront(5)
    node2.insertFront(4)
    node2.insertFront(3)
    node2.insertFront(2)
    node2.insertFront(1)
    node2.insertFront(0)
    head = node2.get_head()
    print("New List is again:")
    node2.display(head)
    headReturn= node2.rotateAlist(head, 6)
    node2.display(headReturn)

    node3 = LinkedList()
    node3.insertFront(2)
    node3.insertFront(1)
    head = node3.get_head()
    print("New List is again:")
    node3.display(head)
    head= node3.rotateAlist(head, )
    node3.display(head)
    #
    # continueLoop=1
    # while(continueLoop):
    #     print("1. Insert in front")
    #     print("2. Insert at the back")
    #     print("3. Sort the LinkedList")
    #     choice = int(input("Enter choice: "))
    #     if(choice==1):
    #         data=int(input("Enter data to be inserted infront: "))
    #         node.insertFront(data)
    #         head=node.get_head()
    #         node.display(head)
    #     elif(choice==2):
    #         data = int(input("Enter data to be inserted at back: "))
    #         node.insertLast(data)
    #         head=node.get_head()
    #         node.display(head)
    #     elif(choice==3):
    #         print("Original List is: ")
    #         head = node.get_head()
    #         node.display(head)
    #         head_new = node.sortList(head)
    #         node.display(head_new)


        # continueLoop=int(input("Want to continue? Press 0 if you want to exit else press 1: "))
main()
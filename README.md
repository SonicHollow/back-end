1. sonic-forum-back-end

   ## �����ļ���
   - src\main\resources\application.properties
   - ���޸�ΪĿ�����ݿ⣬����/Զ��
   - �޸��û���/����

   ## ��Ҫ���û�����
   1. mybatis-plus
   2. lombok
   3. SpringBoot

   ## ���ݿ�����ߣ�
   - ����ʹ�ã�Navicat
   - [����ָ��](https://www.newadmin.cn/archives/1852)

   ## Sql�ļ�·����
   - src\main\resources\sql

   ## Done:
   1. User Table Created
   2. Post Table Created
   3. CURD JUnit Tests
   4. User ����� (�������)
   5. About ��֤�� ���[�ο�����](https://www.cnblogs.com/FlyHeLanMan/p/6293991.html)

   ## To Do:
   1. User Controller �� (User Get�ӿ����)
   2. Post �����
   3. Post Controller ��


   ## About Spring Security (��fixed login)
   1. ������Spring��ȫ��ܣ�ÿ�η���webǰ��Ҫ��������֤
   2. �û���: Ĭ��Ϊ user
   3. ����: �� idea ��������ڣ�ÿ���ɿ���Զ����ɣ���ӡ
   4. ��¼������������������ַ�����ӿڲ���
   5. ToDo ���ڰ���֤�رգ����������� (Done)

   ## API�ĵ�
   �˽�ӿ��ĵ��Ĺ淶���ӿڷ�Ϊ�Ĳ��֣����󷽷���URL��������������ز�����

   1. �������󷽷������ࣺGET��PUT��POST��DELETE
   2. URL
   3. ��������ͷ��ز�������������ͷ��ز�������Ϊ���ֶΡ�˵�������͡���ע���Ƿ������5��
   4. JSON��չ����: Json-handle (Chrome�����֧��)
       ��װ��ʽ��
       1. [��ҳ����](http://jsonhandle.sinaapp.com/)
       2. Chrome���������: `chrome://extensions/` �س�
       3. �������ص� `JSON-handle_0.6.1.crx` ��װ������ҳ�����
       4. Ч��չʾ��

   ![image](https://user-images.githubusercontent.com/83717535/160980775-3b6fbb43-dc1d-42b9-98d5-750c1e1f606a.png)
   ![image](https://user-images.githubusercontent.com/83717535/160981061-94cf3ff4-4146-4a0a-87e5-a96fef533e3a.png)

   

   [API�ĵ�˵���ܽ�](https://blog.csdn.net/qq_34207366/article/details/84579475)

   ```javascript
   {
       "state":200,
       "message":"success",
       "data":{
           "username":"Alice",
           ...
       }
   }
   ```

   ```javascript
   {
       "state":404,
       "message":"Not Found"
       "data":{}
   }
   ```

   ## �ӿڴ���·��
   - path `src\main\java\com\sonichollow\forum\mapper`
   - �ӿھ�������(����)

   ## �ӿ�ά��/���Թ���

   - Postman
   - [APIPost](https://console.apipost.cn/)

   ## UI design markdown editor (Not for back-end)

   - [markdown editor](https://codingdict.com/os/software/51495)

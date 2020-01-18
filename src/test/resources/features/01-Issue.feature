@tag
Feature: Testing Issue REST API

  @Test
  Scenario: Add a new Issue
    Given Set Api
    When I POST to "/payload" with json
      """
      {
         "action":"milestoned",
         "issue":{
            "url":"https://api.github.com/repos/paulo3425/weebhook/issues/7",
            "repository_url":"https://api.github.com/repos/paulo3425/weebhook",
            "labels_url":"https://api.github.com/repos/paulo3425/weebhook/issues/7/labels{/name}",
            "comments_url":"https://api.github.com/repos/paulo3425/weebhook/issues/7/comments",
            "events_url":"https://api.github.com/repos/paulo3425/weebhook/issues/7/events",
            "html_url":"https://github.com/paulo3425/weebhook/issues/7",
            "id":551705620,
            "node_id":"MDU6SXNzdWU1NTE3MDU2MjA=",
            "number":7,
            "title":"issue7",
            "user":{
               "login":"paulo3425",
               "id":10838388,
               "node_id":"MDQ6VXNlcjEwODM4Mzg4",
               "avatar_url":"https://avatars2.githubusercontent.com/u/10838388?v=4",
               "gravatar_id":"",
               "url":"https://api.github.com/users/paulo3425",
               "html_url":"https://github.com/paulo3425",
               "followers_url":"https://api.github.com/users/paulo3425/followers",
               "following_url":"https://api.github.com/users/paulo3425/following{/other_user}",
               "gists_url":"https://api.github.com/users/paulo3425/gists{/gist_id}",
               "starred_url":"https://api.github.com/users/paulo3425/starred{/owner}{/repo}",
               "subscriptions_url":"https://api.github.com/users/paulo3425/subscriptions",
               "organizations_url":"https://api.github.com/users/paulo3425/orgs",
               "repos_url":"https://api.github.com/users/paulo3425/repos",
               "events_url":"https://api.github.com/users/paulo3425/events{/privacy}",
               "received_events_url":"https://api.github.com/users/paulo3425/received_events",
               "type":"User",
               "site_admin":false
            }
         }
      }

      """
    Then Status code should be "201"

  @Test
  Scenario: Receive a existed Issue with new events
    Given Set Api
    When I POST to "/payload" with json
      """
      {
         "action":"milestoned",
         "issue":{
            "url":"https://api.github.com/repos/paulo3425/weebhook/issues/7",
            "repository_url":"https://api.github.com/repos/paulo3425/weebhook",
            "labels_url":"https://api.github.com/repos/paulo3425/weebhook/issues/7/labels{/name}",
            "comments_url":"https://api.github.com/repos/paulo3425/weebhook/issues/7/comments",
            "events_url":"https://api.github.com/repos/paulo3425/weebhook/issues/7/events",
            "html_url":"https://github.com/paulo3425/weebhook/issues/7",
            "id":551705620,
            "node_id":"MDU6SXNzdWU1NTE3MDU2MjA=",
            "number":7,
            "title":"issue7",
            "user":{
               "login":"paulo3425",
               "id":10838388,
               "node_id":"MDQ6VXNlcjEwODM4Mzg4",
               "avatar_url":"https://avatars2.githubusercontent.com/u/10838388?v=4",
               "gravatar_id":"",
               "url":"https://api.github.com/users/paulo3425",
               "html_url":"https://github.com/paulo3425",
               "followers_url":"https://api.github.com/users/paulo3425/followers",
               "following_url":"https://api.github.com/users/paulo3425/following{/other_user}",
               "gists_url":"https://api.github.com/users/paulo3425/gists{/gist_id}",
               "starred_url":"https://api.github.com/users/paulo3425/starred{/owner}{/repo}",
               "subscriptions_url":"https://api.github.com/users/paulo3425/subscriptions",
               "organizations_url":"https://api.github.com/users/paulo3425/orgs",
               "repos_url":"https://api.github.com/users/paulo3425/repos",
               "events_url":"https://api.github.com/users/paulo3425/events{/privacy}",
               "received_events_url":"https://api.github.com/users/paulo3425/received_events",
               "type":"User",
               "site_admin":false
            }
         }
      }

      """
    Then Status code should be "201"

  @Test
  Scenario: Get events
    Given Set Api
    When I GET from "/issues/551705620/events"
    Then Status code should be "200"




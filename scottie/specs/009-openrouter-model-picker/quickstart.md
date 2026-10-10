# Quickstart: OpenRouter Model Picker

## Automated checks (repository root)

```sh
./gradlew :app:assembleDebug
./gradlew :app:testDebugUnitTest --tests '*OpenRouter*' --tests '*ModelDownloadPresenter*'
./gradlew :app:testDebugUnitTest
./gradlew :app:detekt :app:lintDebug
```

Expected host-test coverage:

- Parser fixture: multi-page merge, text filter, missing name/id/modalities, dedupe, sort
  ([models-listing](contracts/models-listing.md)).
- Presenter: Save triggers Loading → Loaded; failure kinds map to messages; Retry refetches;
  toggles save in fetched order; prune after fetch; failed fetch keeps selection; Delete hides the
  list; sections and OpenRouter start collapsed; OpenRouter is first; rotation does not refetch.

## Manual device checks

Prerequisite: an OpenRouter key. Don't run `connectedDebugAndroidTest` without asking first: it
wipes on-device models.

1. Open Settings: OpenRouter is first; every section is collapsed.
2. Expand OpenRouter, keep the default URL, enter the key, tap Save: loading, then a sorted list
   appears within about 3 s.
3. Type `haiku`: list narrows; check one; clear the search: it is still checked. Check a second
   model.
4. Back to chat, open the selector: the two models appear after on-device models, marked remote;
   send a message to each and get replies.
5. Airplane mode, reopen Settings, expand OpenRouter: "Couldn't reach the service" + Retry; chat
   still lists both models. Turn the network on, tap Retry: list returns with both checked.
6. Enter a wrong key, Save: authentication error with Retry.
7. Rotate with the list open: search text, scroll, and checks are kept; no reload.
8. Leave Settings and reopen: every section is collapsed again.
9. Delete: list hidden; chat shows no remote models.
